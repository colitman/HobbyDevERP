/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.hobbydev.webapp.erp.business.ResourceNotFoundException;
import ua.hobbydev.webapp.erp.business.users.UserServiceInterface;
import ua.hobbydev.webapp.erp.domain.users.User;
import ua.hobbydev.webapp.erp.web.models.users.UserModel;

@RestController
@RequestMapping(path="api/")
public class UsersController {

    @Autowired
    private UserServiceInterface userService;

    @RequestMapping(path = "users/{username}", method = RequestMethod.GET)
    public ResponseEntity<UserModel> getUser(@RequestParam String user,
                                             @RequestParam String token,
                                             @PathVariable String username) {
        User dbUser = null;
        try {
            dbUser = userService.get(username);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
        }

        UserModel userModel = new UserModel(dbUser);

        return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
    }
}
