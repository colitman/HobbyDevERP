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
import ua.hobbydev.webapp.erp.data.ObjectNotExistsException;
import ua.hobbydev.webapp.erp.data.auth.AuthDAOFactoryInterface;
import ua.hobbydev.webapp.erp.data.auth.AuthDAOInterface;

import java.util.Collection;

@Service
public class UserAuthService implements UserAuthServiceInterface {

    private @Value("${auth.dao.name}") String authDaoName;

    @Autowired
    private AuthDAOFactoryInterface authDaoFactory;

    private AuthDAOInterface getAuthDao() {
        return authDaoFactory.getDao(authDaoName);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(!getAuthDao().usernameExists(username)) {
            throw new UsernameNotFoundException("Username not found:[" + username + "]");
        }

        AuthUser user = new AuthUser();
        user.setUsername(username);
        try {
            user.setPassword(getAuthDao().getPasswordForUsername(username));
        } catch (ObjectNotExistsException e) {
            throw new UsernameNotFoundException("Username not found:[" + username + "]");
        }

        return user;
    }

    private class AuthUser implements UserDetails {
        private String username;
        private String password;

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
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return AuthorityUtils.NO_AUTHORITIES;
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
