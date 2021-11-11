package com.senla.haltvinizki.dao.connect;

import com.senla.haltvinizki.configuration.PropertyConfiguration;
import com.senla.haltvinizki.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class DbConnect {
    private static DbConnect dbConnect;
    private Connection connection;
    private final PropertyConfiguration configuration = new PropertyConfiguration();

    public static DbConnect getInstance() {
        if (dbConnect == null) {
            dbConnect = new DbConnect();
        }
        return dbConnect;
    }

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
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
