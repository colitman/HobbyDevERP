/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(method=RequestMethod.GET)
public class BaseController {

	@PreAuthorize(value = "isAuthenticated()")
	@RequestMapping(path="/")
	public ModelAndView getRootPage(ModelAndView mv, Authentication auth) {

		mv.addObject("username", auth.getName());
		mv.setViewName("user");
		
		return mv;
	}

	@RequestMapping(path = "/signin")
	public ModelAndView getSignInPage(ModelAndView mv, Authentication principal) {
		if(principal != null && principal.isAuthenticated()) {
			mv.setViewName("redirect:/");
		} else {
			mv.setViewName("signin");
		}

		return mv;
	}
}
