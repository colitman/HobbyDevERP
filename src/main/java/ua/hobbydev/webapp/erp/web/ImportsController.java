/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.hobbydev.webapp.erp.business.ResourceNotFoundException;
import ua.hobbydev.webapp.erp.business.users.UserServiceInterface;
import ua.hobbydev.webapp.erp.domain.users.User;

@Controller
@RequestMapping(path="/imports", method=RequestMethod.GET)
public class ImportsController {

	@Autowired
	private UserServiceInterface userService;

	@RequestMapping(path="/head")
	public ModelAndView getHead(@RequestParam(name="pageTitle", required=false) String title,
								  ModelAndView mv) {
		mv.addObject("pageTitle", title);
		mv.setViewName("imports/head");
		
		return mv;
	}

	@RequestMapping(path="/mainNav")
	public ModelAndView getMainNav(@RequestParam(name="root", defaultValue="false") String root,
								   Authentication loggedUser,
								   ModelAndView mv) {

		User user = null;
		if(loggedUser != null && loggedUser.isAuthenticated()) {
			try {
				user = userService.get(loggedUser.getName());
				mv.addObject("loggedUserName", user.getUserInfo().getFirstName() + " " + user.getUserInfo().getLastName());
			} catch (ResourceNotFoundException e) {
				// TODO add logging
			}
		}

		mv.addObject("root", root);
		mv.setViewName("imports/mainNav");

		return mv;
	}

	@RequestMapping(path="/mainFooter")
	public ModelAndView getMainFooter(ModelAndView mv) {
		mv.setViewName("imports/mainFooter");

		return mv;
	}

	@RequestMapping(path="/scripts")
	public ModelAndView getScripts(ModelAndView mv) {
		mv.setViewName("imports/scripts");

		return mv;
	}

	@RequestMapping(path="/modals/{modalName}")
	public ModelAndView getModal(@PathVariable String modalName,
								  ModelAndView mv) {

		mv.setViewName("imports/modals/" + modalName);

		return mv;
	}
}
