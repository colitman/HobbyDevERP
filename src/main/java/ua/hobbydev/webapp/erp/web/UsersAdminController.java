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
import ua.hobbydev.webapp.erp.domain.users.PersonalInfo;
import ua.hobbydev.webapp.erp.domain.users.User;
import ua.hobbydev.webapp.erp.domain.users.UserInfo;

import java.io.IOException;
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
	@RequestMapping(path="/users/{username}", method = RequestMethod.POST)
	public ModelAndView updateRole(@PathVariable String username,
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

		mv.setViewName("redirect:/admin/users/" + username);
		return mv;
	}

	private void deleteUser(String username) throws ResourceNotFoundException {
		userService.delete(PersonalInfo.class, userService.get(username).getPersonalInfo().getKey());
		userService.delete(UserInfo.class, userService.get(username).getUserInfo().getKey());
		userService.delete(User.class, userService.get(username).getKey());
	}
}
