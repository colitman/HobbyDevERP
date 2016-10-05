/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.hobbydev.webapp.erp.business.ResourceNotFoundException;
import ua.hobbydev.webapp.erp.business.users.UserServiceInterface;
import ua.hobbydev.webapp.erp.domain.users.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/")
public class UsersAdminController {

	@Autowired
	private UserServiceInterface userService;

	@PreAuthorize(value = "hasAuthority('VIEW_USERS_PAGE')")
	@RequestMapping(path="/users", method = RequestMethod.GET)
	public ModelAndView getUsersPage(ModelAndView mv) {

		List<User> users = userService.list();

		mv.addObject("users", users);
		mv.setViewName("users");
		return mv;
	}

    @PreAuthorize(value = "hasAuthority('EDIT_USER')")
    @RequestMapping(path="/users/{username}", method = RequestMethod.GET)
    public ModelAndView getUserEditPage(@PathVariable String username,
                                   ModelAndView mv) {

        User user = null;

        try {
            user = userService.get(username);
            List<User> managers = userService.list();
            mv.addObject("user", user);
            mv.addObject("managers", managers);
        } catch (ResourceNotFoundException e) {
            mv.setViewName("redirect:/errors/404");
            return mv;
        }

        mv.setViewName("editUser");
        return mv;
    }

	@PreAuthorize(value = "hasAuthority('EDIT_USER')")
	@RequestMapping(path="/users/{username}", method = RequestMethod.POST)
	public ModelAndView updateUser(@PathVariable String username,
                                   @RequestParam String startOfWork,
                                   @RequestParam (required = false) String birthday,
                                   @RequestParam String lineManager,
                                   @RequestParam String personalPhone,
                                   @RequestParam String skypeName,
								   @RequestParam (required = false, defaultValue = "false") boolean isDeleted,
								   ModelAndView mv) throws IOException {

		if(isDeleted) {
			try {
				deleteUser(username);
				mv.setViewName("redirect:/admin/users");
				return mv;
			} catch (ResourceNotFoundException e) {
				throw new IOException("Invalid username");
			}

		}

		User user = null;

        try {
            user = userService.get(username);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date startOfWorkDate = null;
            try {
                startOfWorkDate = formatter.parse(startOfWork);
                user.getUserInfo().setStartOfWork(startOfWorkDate);
            } catch (ParseException e) {
                //TODO add logging
            }

            Date birthdayDate = null;
            if(birthday != null) {
                try {
                    birthdayDate = formatter.parse(birthday);
                    user.getPersonalInfo().setBirthday(birthdayDate);
                } catch (ParseException e) {
                    //TODO add logging
                }
            }

            if(lineManager != null && !lineManager.trim().isEmpty()) {
                User manager = null;
                manager = userService.get(lineManager);
                user.setLineManager(manager);
            } else {
                user.setLineManager(null);
            }

            user.getPersonalInfo().setPhoneNumber(personalPhone);
            user.getPersonalInfo().setSkypeName(skypeName);

            userService.update(user);

        } catch (ResourceNotFoundException e) {
            throw new IOException("Invalid username or line manager name");
        }

        mv.setViewName("redirect:/users/" + username);
		return mv;
	}

	private void deleteUser(String username) throws ResourceNotFoundException {
		userService.delete(User.class, userService.get(username).getKey());
	}
}
