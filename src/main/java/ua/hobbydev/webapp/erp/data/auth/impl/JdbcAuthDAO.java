/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.data.auth.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ua.hobbydev.webapp.erp.data.ObjectNotExistsException;
import ua.hobbydev.webapp.erp.data.auth.AuthDAOInterface;

import java.beans.PropertyVetoException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        PreparedStatement ps = null;
        ResultSet rs = null;

        boolean exists = false;

        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(props.getProperty("auth.jdbc.query.usernameExists", "select count(users.username) from users where users.username = ?"));
            ps.setString(1, username);
            rs = ps.executeQuery();

            if(rs.next()) {
                exists = rs.getInt(1) != 0;
            }

        } catch (SQLException e) {
            return exists;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                //TODO add logging
            }
        }

        return exists;
    }

    @Override
    public String getPasswordForUsername(String username) throws ObjectNotExistsException {
        PreparedStatement ps = null;
        ResultSet rs = null;

        String password = "";

        if(!usernameExists(username)) {
            throw new ObjectNotExistsException("User with provided username not found:[" + username + "]");
        }

        try {
            con = dataSource.getConnection();
            ps = con.prepareStatement(props.getProperty("auth.jdbc.query.getPassword", "select creds.password from creds where creds.user_key = (select users.key from users where users.username = ?)"));
            ps.setString(1, username);
            rs = ps.executeQuery();

            if(rs.next()) {
                password = rs.getString(1);
            }

        } catch (SQLException e) {
            return password;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                //TODO add logging
            }
        }

        return password;
    }
}
