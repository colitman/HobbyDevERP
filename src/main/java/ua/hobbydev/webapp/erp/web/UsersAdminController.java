/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.hobbydev.webapp.erp.business.users.UserServiceInterface;
import ua.hobbydev.webapp.erp.domain.users.User;

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
}
