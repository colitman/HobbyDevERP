/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/imports", method=RequestMethod.GET)
public class ImportsController {

	@RequestMapping(path="/{importName}")
	public ModelAndView getImport(@PathVariable String importName,
									@RequestParam(name="pageTitle", required=false) String title,
									@RequestParam(name="root", defaultValue="false") String root,
									ModelAndView mv) {
		mv.addObject("pageTitle", title);
		mv.addObject("root", root);
		mv.setViewName("imports/" + importName);
		
		return mv;
	}

	@RequestMapping(path="/modals/{modalName}")
	public ModelAndView getModal(@PathVariable String modalName,
								  ModelAndView mv) {

		mv.setViewName("imports/modals/" + modalName);

		return mv;
	}
}
