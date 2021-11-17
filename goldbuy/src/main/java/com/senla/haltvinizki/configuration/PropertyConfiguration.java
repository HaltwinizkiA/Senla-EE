package com.senla.haltvinizki.configuration;

import com.senla.haltvinizki.util.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class PropertyConfiguration {
    private final Properties properties;
    private final String PATH = "resources/application.properties";

    public PropertyConfiguration() {
        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(new File(PATH).getAbsolutePath())) {
            properties.load(inputStream);
        } catch (IOException e) {
            Logger.execute(this.getClass(), e);
        }
    }

    public String getUrl() {
        return properties.getProperty("URL");
    }

    public String getName() {
        return properties.getProperty("NAME");
    }

    public String getPassword() {
        return properties.getProperty("PASSWORD");
    }

}
