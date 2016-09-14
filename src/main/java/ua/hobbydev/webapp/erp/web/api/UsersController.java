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
import ua.hobbydev.webapp.erp.web.models.incoming.users.FrontEndUserModel;
import ua.hobbydev.webapp.erp.web.models.users.FlatUserCollectionItem;
import ua.hobbydev.webapp.erp.web.models.users.UserModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @RequestMapping(path = "users", method = RequestMethod.GET)
    public ResponseEntity<List<FlatUserCollectionItem>> getAllUsers(@RequestParam String user,
                                                                    @RequestParam String token) {
        List<User> dbUsers = userService.list();

        List<FlatUserCollectionItem> users = new ArrayList<FlatUserCollectionItem>();

        for(User u:dbUsers) {
            users.add(new FlatUserCollectionItem(u));
        }

        return new ResponseEntity<List<FlatUserCollectionItem>>(users, HttpStatus.OK);
    }

    @RequestMapping(path = "users/{username}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@RequestParam String user,
                                             @RequestParam String token,
                                             @PathVariable String username,
                                             @RequestBody FrontEndUserModel model) {
        User dbUser = null;
        try {
            dbUser = userService.get(username);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }

        Long lineManagerId = model.getLineManager();

        if(lineManagerId == null || lineManagerId < 0) {
            dbUser.setLineManager(null);
        } else {
            User dbLineManager = null;
            try {
                dbLineManager = userService.get(model.getLineManager());
            } catch (ResourceNotFoundException e) {
                return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
            }
            dbUser.setLineManager(dbLineManager);
        }

        dbUser.getUserInfo().setCorporatePhoneNumber(model.getCorporatePhoneNumber());
        dbUser.getUserInfo().setEmail(model.getEmail());
        dbUser.getUserInfo().setFirstName(model.getFirstName());
        dbUser.getUserInfo().setLastName(model.getLastName());
        dbUser.getUserInfo().setMiddleName(model.getMiddleName());

        dbUser.getPersonalInfo().setBirthday(new Date(model.getBirthday()));
        dbUser.getPersonalInfo().setPhoneNumber(model.getPhoneNumber());
        dbUser.getPersonalInfo().setSkypeName(model.getSkypeName());

        try {
            userService.update(dbUser);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
