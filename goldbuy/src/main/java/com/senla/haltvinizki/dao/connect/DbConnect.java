package com.senla.haltvinizki.dao.connect;

import com.senla.haltvinizki.util.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;

@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
@Configuration
@EnableAspectJAutoProxy
public class DbConnect {

    @Value("${name}")
    private String name;
    @Value("${url}")
    private String url;
    @Value("${password}")
    private String password;
    private Connection connection;

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            Logger.execute(this.getClass(), e);
        }
    }

    @Bean(destroyMethod = "close")
    public Connection getConnection() {
        connect();
        return connection;
    }

    public String getName() {
        return name;
    }
}
