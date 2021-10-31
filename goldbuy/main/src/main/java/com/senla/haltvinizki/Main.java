package com.senla.haltvinizki;

import com.senla.haltvinizki.controllers.UserController;
import com.senla.haltvinizki.controllers.impl.UserControllerImpl;
import сom.senlainc.injection.DependencyInjector;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
//        ScanClas.run("model.com.senla.haltvinizki.entity");


        UserController userController = DependencyInjector.run("C:\\Users\\37533\\Projects\\Senla-EE\\goldbuy\\main\\src\\main\\resources\\diProperty.properties").get(UserControllerImpl.class);
        userController.execute();
    }

}
