/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.data.auth.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import ua.hobbydev.webapp.erp.data.ObjectNotExistsException;
import ua.hobbydev.webapp.erp.data.auth.AuthDAOInterface;

import java.beans.PropertyVetoException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

@Repository
public class JdbcAuthDAO implements AuthDAOInterface {

    private Properties props;
    private ComboPooledDataSource dataSource;
    private Connection con;

    public JdbcAuthDAO() {
        props = new Properties();
        try {
            props.load(new FileReader(new ClassPathResource("application.properties").getFile()));
        } catch (IOException e) {
            //TODO add logging
        }

        dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(props.getProperty("auth.jdbc.driverClassName", "org.postgresql.Driver"));
        } catch (PropertyVetoException e) {
            //TODO add logging
        }
        dataSource.setJdbcUrl(props.getProperty("auth.jdbc.url", "jdbc:postgresql://localhost:5432/hderp"));
        dataSource.setUser(props.getProperty("auth.jdbc.login", "postgres"));
        dataSource.setPassword(props.getProperty("auth.jdbc.password", "qwerty"));
    }

    @Override
    public boolean usernameExists(String username) {

        boolean exists = false;

        JdbcTemplate template = new JdbcTemplate(dataSource);
        exists = template.queryForObject(
                props.getProperty("auth.jdbc.query.usernameExists", "select count(users.username) from users where users.username = ?"),
                Integer.class,
                username
        ) != 0;

        return exists;
    }

    @Override
    public String getPasswordForUsername(String username) throws ObjectNotExistsException {

        String password = "";

        if(!usernameExists(username)) {
            throw new ObjectNotExistsException("User with provided username not found:[" + username + "]");
        }

        JdbcTemplate template = new JdbcTemplate(dataSource);
        password = template.queryForObject(
                props.getProperty("auth.jdbc.query.getPassword", "select creds.password from creds where creds.user_key = (select users.key from users where users.username = ?)"),
                String.class,
                username
        );

        return password;
    }

    @Override
    public Map<String, String> getAdditionalUserDetails(String username) throws ObjectNotExistsException {
        Map<String, String> details = new Hashtable<String, String>();

        if(!usernameExists(username)) {
            throw new ObjectNotExistsException("User with provided username not found:[" + username + "]");
        }

        JdbcTemplate template = new JdbcTemplate(dataSource);

        details = template.query(props.getProperty(
                "auth.jdbc.query.getAdditionalDetails"),
                new String[]{username},
                new ResultSetExtractor<Map<String, String>>() {

                    @Override
                    public Map<String, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
                        Map<String, String> data = new Hashtable<String, String>();

                        while (rs.next()) {
                            data.put(rs.getString(1), String.valueOf(rs.getObject(2)));
                        }

                        return data;
                    }
                });

        return details;
    }
}
