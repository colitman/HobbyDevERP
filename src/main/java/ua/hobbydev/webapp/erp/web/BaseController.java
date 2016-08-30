/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(method=RequestMethod.GET)
public class BaseController {

	@RequestMapping(path="/")
	public ModelAndView root(ModelAndView mv) {

		mv.setViewName("root");
		
		return mv;
	}
}
