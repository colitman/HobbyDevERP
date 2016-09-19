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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(method=RequestMethod.GET, path = "/admin/")
public class AdminNavController {

	@PreAuthorize(value = "hasAuthority('VIEW_ROLES_ADMIN_PAGE')")
	@RequestMapping(path="/roles")
	public ModelAndView getRolesPage(ModelAndView mv) {

		mv.setViewName("rolesAdmin");
		return mv;
	}

	//@PreAuthorize(value = "hasAuthority('VIEW_ROLE_EDIT_PAGE')")
	@RequestMapping(path="/roles/{key}")
	public ModelAndView getRoleEditPage(@PathVariable String key,
										ModelAndView mv) {

		mv.setViewName("roleEdit");
		mv.addObject("roleKey", key);
		return mv;
	}
}
