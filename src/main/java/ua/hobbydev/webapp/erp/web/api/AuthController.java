/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.web.api;

import org.jasypt.springsecurity3.authentication.encoding.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.hobbydev.webapp.erp.business.DefaultServiceInterface;
import ua.hobbydev.webapp.erp.business.ResourceAlreadyExistsException;
import ua.hobbydev.webapp.erp.business.ResourceNotFoundException;
import ua.hobbydev.webapp.erp.business.users.UserAuthServiceInterface;
import ua.hobbydev.webapp.erp.business.users.UserServiceInterface;
import ua.hobbydev.webapp.erp.domain.users.AuthToken;
import ua.hobbydev.webapp.erp.domain.users.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping(path="api/")
public class AuthController {

	@Autowired
	private UserAuthServiceInterface userAuthService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private DefaultServiceInterface defaultService;
	@Autowired
	private UserServiceInterface userService;

	@RequestMapping(path="auths", method=RequestMethod.POST)
	public ResponseEntity<String> authenticate(@RequestParam String username,
											   @RequestParam String password,
											   HttpServletRequest req) {
		String token = "";
		HttpStatus status;

		UserDetails user = null;
		try {
			user = userAuthService.loadUserByUsername(username);
		} catch (UsernameNotFoundException unfe) {
			return new ResponseEntity<String>("User not found:[" + username + "]", HttpStatus.NOT_FOUND);
		}

		if(passwordEncoder.isPasswordValid(user.getPassword(), password, null)) {
			status = HttpStatus.OK;

			User dbUser = null;
			try {
				dbUser = userService.get(username);
			} catch (ResourceNotFoundException e) {
				//TODO add logging
			}

			token = String.valueOf(username.hashCode()) + String.valueOf(req.getRemoteAddr().hashCode()) + String.valueOf(String.valueOf(new Date().getTime()).hashCode());
			token = String.valueOf(token.hashCode() > 0 ? token.hashCode() : Math.abs(token.hashCode()));

			AuthToken dbToken = new AuthToken();
			dbToken.setUser(dbUser);
			dbToken.setToken(passwordEncoder.encodePassword(token, null));

			try {
				defaultService.add(dbToken);
			} catch (ResourceAlreadyExistsException e) {
				//TODO add logging
			}
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		
		ResponseEntity<String> response = new ResponseEntity<String>(token, status);
		return response;
	}
}
