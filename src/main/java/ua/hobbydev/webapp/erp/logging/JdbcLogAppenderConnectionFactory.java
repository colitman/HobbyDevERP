/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ua.hobbydev.webapp.erp.logging;

public class JdbcLogAppenderConnectionFactory {
/*
    private static JdbcLogAppenderConnectionFactory instance = null;

    public static JdbcLogAppenderConnectionFactory getInstance() {
        if(instance == null) {
            instance = new JdbcLogAppenderConnectionFactory();
        }

        return  instance;
    }

    private ComboPooledDataSource dataSource;

    private JdbcLogAppenderConnectionFactory() {
        Properties props = new Properties();
        try {
            props.load(new FileReader(new ClassPathResource("application.properties").getFile()));
        } catch (IOException e) {
            //TODO add logging
        }

        String jdbcURL = "jdbc:postgresql://" + props.getProperty("jdbc.host", "localhost") + ":" + props.getProperty("jdbc.port", "5432") + "/" + props.getProperty("jdbc.dbName", "hderp");

        dataSource = new ComboPooledDataSource();

        try {
            dataSource.setDriverClass(props.getProperty("jdbc.driverClassName", "org.postgresql.Driver"));
        } catch (PropertyVetoException e) {
            //TODO add logging
        }

        dataSource.setUser(props.getProperty("jdbc.login", "postgres"));
        dataSource.setPassword(props.getProperty("jdbc.password", "qwerty"));
        dataSource.setJdbcUrl(jdbcURL);
        dataSource.setMaxPoolSize(10);
        dataSource.setMinPoolSize(5);
        dataSource.setMaxStatements(100);
        dataSource.setTestConnectionOnCheckout(false);

        //GenericObjectPool pool = new GenericObjectPool();
        /*DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
                jdbcURL, properties
        );

        ObjectPoolFactory poolFactory = new GenericObjectPoolFactory();

        this.dataSource = new PoolingDataSource(pool);*/

        /*dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(props.getProperty("jdbc.driverClassName", "org.postgresql.Driver"));
        } catch (PropertyVetoException e) {
            //TODO add logging
        }

        String jdbcURL = "jdbc:postgresql://" + props.getProperty("jdbc.host", "localhost") + ":" + props.getProperty("jdbc.port", "5432") + "/" + props.getProperty("jdbc.dbName", "hderp");

        dataSource.setJdbcUrl(jdbcURL);
        dataSource.setUser(props.getProperty("jdbc.login", "postgres"));
        dataSource.setPassword(props.getProperty("jdbc.password", "qwerty"));*/
    /*}

    public static Connection getConnection() throws SQLException {
        return getInstance().dataSource.getConnection();
    }*/

}
