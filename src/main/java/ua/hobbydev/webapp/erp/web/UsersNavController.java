/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(method=RequestMethod.GET)
public class UsersNavController {

	@PreAuthorize(value = "isAuthenticated()")
	@RequestMapping(path="/users/{username}")
	public ModelAndView getUserPage(@PathVariable String username,
									@RequestParam (required = false) String action,
									ModelAndView mv) {

		mv.addObject("username", username);

		if(action == null) {
			mv.setViewName("user");
			return mv;
		}

		switch (action) {
			case "edit":
				mv.setViewName("userEdit");
				break;
			default:
				mv.setViewName("user");
		}

		return mv;
	}
}
