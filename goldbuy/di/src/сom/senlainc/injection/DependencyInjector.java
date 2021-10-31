package сom.senlainc.injection;


import сom.senlainc.configuration.PropertyConfiguration;

import java.io.File;

public class DependencyInjector {


    public static ApplicationContext run(String propertyPath) {
        PropertyConfiguration propertyConfiguration = new PropertyConfiguration(propertyPath);
        ApplicationContext applicationContext = new ApplicationContext();
        ClassScanner classScanner = new ClassScanner(propertyConfiguration.getProperty("directory"));
        applicationContext.setPropertyConfiguration(propertyConfiguration);
        applicationContext.setClassSet(classScanner.getClassSet());
        applicationContext.createContext();
        return applicationContext;
    }
}
