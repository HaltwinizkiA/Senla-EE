package com.senla.haltvinizki.dao.connect;

import com.senla.haltvinizki.configuration.PropertyConfiguration;
import com.senla.haltvinizki.util.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    private static DbConnect dbConnect;
    private Connection connection;
    private PropertyConfiguration configuration;

    public static DbConnect getInstance() {
        if (dbConnect == null) {
            dbConnect = new DbConnect();
        }
        return dbConnect;
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(configuration.getUrl(), configuration.getName(), configuration.getPassword());
        } catch (Exception e) {
            Logger.execute(this.getClass(), e);
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            connect();
        }
        return connection;
    }

}
