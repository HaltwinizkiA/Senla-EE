package сom.senlainc.configuration;

import logger.Logger;
import сom.senlainc.injection.exception.InjectionException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyConfiguration {

    private final Properties properies;

    public PropertyConfiguration(String path) {
        properies = init(path);
    }

    private Properties init(String path) {
        File file=new File(path);
        try (FileInputStream inputStream = new FileInputStream(file.getAbsolutePath())) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            Logger.log(this.getClass(), e);
            throw new InjectionException("not found property file");
        }
    }

    public String getProperty(String key) {
        return properies.getProperty(key);
    }
}
