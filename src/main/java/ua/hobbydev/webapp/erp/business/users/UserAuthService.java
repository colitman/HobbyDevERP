/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.business.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.hobbydev.webapp.erp.business.ResourceAlreadyExistsException;
import ua.hobbydev.webapp.erp.business.ResourceNotFoundException;
import ua.hobbydev.webapp.erp.data.ObjectNotExistsException;
import ua.hobbydev.webapp.erp.data.auth.AuthDAOFactoryInterface;
import ua.hobbydev.webapp.erp.data.auth.AuthDAOInterface;
import ua.hobbydev.webapp.erp.domain.users.User;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class UserAuthService implements UserAuthServiceInterface {

    private @Value("${auth.dao.name}") String authDaoName;
    private @Value("${auth.jdbc.details.firstName}") String firstName;
    private @Value("${auth.jdbc.details.lastName}") String lastName;
    private @Value("${auth.jdbc.details.email}") String email;
    private @Value("${auth.jdbc.details.corporatePhone}") String corporatePhone;

    @Autowired
    private AuthDAOFactoryInterface authDaoFactory;

    @Autowired UserServiceInterface userService;

    private AuthDAOInterface getAuthDao() {
        return authDaoFactory.getDao(authDaoName);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(!getAuthDao().usernameExists(username)) {
            throw new UsernameNotFoundException("Username not found:[" + username + "]");
        }

        AuthUser authUser = new AuthUser();
        authUser.setUsername(username);
        try {
            authUser.setPassword(getAuthDao().getPasswordForUsername(username));
        } catch (ObjectNotExistsException e) {
            throw new UsernameNotFoundException("Username not found:[" + username + "]");
        }

        User user = null;

        if(!userService.exists(username)) {
            user = new User();
            user.setUsername(authUser.getUsername());
            Map<String, String> details = new Hashtable<String, String>();

            try {
                details = getAuthDao().getAdditionalUserDetails(username);
            } catch (ObjectNotExistsException e) {
                throw new UsernameNotFoundException("Username not found:[" + username + "]");
            }

            user.getUserInfo().setFirstName(details.get(firstName));
            user.getUserInfo().setLastName(details.get(lastName));
            user.getUserInfo().setEmail(details.get(email));
            user.getUserInfo().setCorporatePhoneNumber(details.get(corporatePhone));

            //TODO add support for dates

            try {
                userService.add(user);
            } catch (ResourceAlreadyExistsException e) {
                //TODO add logging
            }
        } else {
            try {
                user = userService.get(username);
            } catch (ResourceNotFoundException e) {
                throw new UsernameNotFoundException("Username not found:[" + username + "]");
            }
        }

        if(user.getRole() != null) {
            String authoritiesString = user.getRole().getAuthorities();
            List<GrantedAuthority> authoritiesList = AuthorityUtils.commaSeparatedStringToAuthorityList(authoritiesString);

            authUser.setAuthorities(authoritiesList);
        }

        return authUser;
    }

    private class AuthUser implements UserDetails {
        private String username;
        private String password;
        private List<GrantedAuthority> authorities = AuthorityUtils.NO_AUTHORITIES;

        @Override
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public List<GrantedAuthority> getAuthorities() {
            return authorities;
        }

        public void setAuthorities(List<GrantedAuthority> authorities) {
            if(authorities != null) {
                this.authorities = authorities;
            }
        }

        @Override
        public boolean isEnabled() {
            return true;
        }


        @Override
        public boolean isAccountNonExpired() {
            return isEnabled();
        }

        @Override
        public boolean isAccountNonLocked() {
            return isEnabled();
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return isEnabled();
        }
    }
}
