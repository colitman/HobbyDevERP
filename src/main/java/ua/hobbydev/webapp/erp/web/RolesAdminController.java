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
import ua.hobbydev.webapp.erp.business.ResourceAlreadyExistsException;
import ua.hobbydev.webapp.erp.business.ResourceNotFoundException;
import ua.hobbydev.webapp.erp.business.roles.RoleServiceInterface;
import ua.hobbydev.webapp.erp.domain.roles.UserRole;

import java.util.List;

@Controller
@RequestMapping(path = "/admin/")
public class RolesAdminController {

	@Autowired
	private RoleServiceInterface roleService;

	@PreAuthorize(value = "hasAuthority('VIEW_ROLES_PAGE')")
	@RequestMapping(path="/roles", method = RequestMethod.GET)
	public ModelAndView getRolesPage(ModelAndView mv) {

		List<UserRole> roles = roleService.list();

		mv.addObject("roles", roles);
		mv.setViewName("roles");
		return mv;
	}

	@PreAuthorize(value = "hasAuthority('ADD_ROLE')")
	@RequestMapping(path="/roles", method = RequestMethod.POST)
	public ModelAndView createRole(@RequestParam String name,
								   @RequestParam(required = false) String description,
								   ModelAndView mv) {

		UserRole role = new UserRole();
		role.setName(name);
		role.setDescription(description);
		role.setAuthorities("");

		try {
			roleService.add(role);
		} catch (ResourceAlreadyExistsException e) {
			//TODO add logging
		}

		mv.setViewName("redirect:/admin/roles");
		return mv;
	}

	@PreAuthorize(value = "hasAuthority('EDIT_ROLE')")
	@RequestMapping(path="/roles/{key}", method = RequestMethod.GET)
	public ModelAndView getRoleEditPage(@PathVariable Long key,
										ModelAndView mv) {

		UserRole role = null;

		try {
			role = roleService.get(key);
		} catch (ResourceNotFoundException e) {
			mv.setViewName("redirect:/errors/404");
			return mv;
		}

		mv.addObject("role", role);
		mv.setViewName("role");
		return mv;
	}
}
