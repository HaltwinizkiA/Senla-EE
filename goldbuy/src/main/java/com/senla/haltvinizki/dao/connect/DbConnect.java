package com.senla.haltvinizki.dao.connect;

import com.senla.haltvinizki.configuration.PropertyConfiguration;
import com.senla.haltvinizki.util.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.sql.Connection;
import java.sql.DriverManager;


@Configuration
@EnableAspectJAutoProxy
public class DbConnect {

    private final PropertyConfiguration configuration;
    private Connection connection;

    public DbConnect(PropertyConfiguration configuration) {
        this.configuration = configuration;
    }


    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(configuration.getUrl(), configuration.getName(), configuration.getPassword());
        } catch (Exception e) {
            Logger.execute(this.getClass(), e);
        }
    }

    @Bean(destroyMethod = "close")
    public Connection getConnection() {
        if (connection == null) {
            connect();
        }
        return connection;
    }

}
