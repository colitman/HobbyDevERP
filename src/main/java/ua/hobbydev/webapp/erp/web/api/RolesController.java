/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.hobbydev.webapp.erp.business.roles.RoleServiceInterface;
import ua.hobbydev.webapp.erp.domain.roles.UserRole;
import ua.hobbydev.webapp.erp.web.models.roles.UserRoleModel;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="api/")
public class RolesController {

    @Autowired
    private RoleServiceInterface roleService;

    @RequestMapping(path = "roles", method = RequestMethod.GET)
    public ResponseEntity<List<UserRoleModel>> getAllRoles(@RequestParam String user,
                                                           @RequestParam String token) {
        List<UserRole> dbRoles = roleService.list();

        List<UserRoleModel> roles = new ArrayList<UserRoleModel>();

        for(UserRole ur:dbRoles) {
            roles.add(new UserRoleModel(ur));
        }

        return new ResponseEntity<List<UserRoleModel>>(roles, HttpStatus.OK);
    }
}
