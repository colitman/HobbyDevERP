/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Service;
import ua.hobbydev.webapp.erp.web.api.AuthController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Autowired
    private AuthController authController;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        String token = "";

        Cookie[] cookies = request.getCookies();

        for(Cookie c:cookies) {
            String cookieName = c.getName();
            if(!cookieName.equalsIgnoreCase("token") && !cookieName.equalsIgnoreCase("user")) {
                continue;
            }

            token = c.getValue();
        }

        authController.unauthenticate(request.getParameter("username"), token);
        response.addCookie(new Cookie("token",""));
        response.addCookie(new Cookie("user",""));

        super.onLogoutSuccess(request, response, authentication);
    }
}
