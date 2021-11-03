package com.senla.haltvinizki;

import com.senla.haltvinizki.controllers.UserController;
import com.senla.haltvinizki.controllers.impl.UserControllerImpl;
import сom.senlainc.injection.DependencyInjector;
import java.net.URISyntaxException;



public class Main {
    public static void main(String[] args) throws  URISyntaxException {

        UserController userController = DependencyInjector.run("resources/diProperty.properties").get(UserControllerImpl.class);
        userController.execute();
    }

}
