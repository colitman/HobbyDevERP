/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.hobbydev.webapp.erp.business.ResourceNotFoundException;
import ua.hobbydev.webapp.erp.business.users.UserServiceInterface;
import ua.hobbydev.webapp.erp.domain.users.User;

@Controller
@RequestMapping(method=RequestMethod.GET)
public class UsersBaseController {

	@Autowired
	private UserServiceInterface userService;

	@PreAuthorize(value = "isAuthenticated()")
	@RequestMapping(path="/profile")
	public ModelAndView getProfilePage(Authentication loggedUser,
									ModelAndView mv) {

		User user = null;

		try {
			user = userService.get(loggedUser.getName());
			mv.addObject("user", user);
		} catch (ResourceNotFoundException e) {
			mv.setViewName("redirect:/errors/404");
			return mv;
		}

		mv.setViewName("profile");
		return mv;
	}

	@PreAuthorize(value = "hasAuthority('VIEW_USER_PAGE')")
	@RequestMapping(path="/users/{username}")
	public ModelAndView getUserPage(@PathVariable String username,
									Authentication loggedUser,
									ModelAndView mv) {

		if(loggedUser.getName().equals(username)) {
			mv.setViewName("redirect:/profile");
			return mv;
		}

		User user = null;

		try {
			user = userService.get(username);
			mv.addObject("user", user);
		} catch (ResourceNotFoundException e) {
			mv.setViewName("redirect:/errors/404");
			return mv;
		}

		mv.setViewName("profile");
		return mv;
	}
}
