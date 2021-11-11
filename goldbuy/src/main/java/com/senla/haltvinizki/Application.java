package com.senla.haltvinizki;


import com.senla.haltvinizki.controllers.CategoryController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args){

        String categoryJson="{\"name\":\"Furniture\"}";
//        PropertyConfiguration propertyConfiguration=new PropertyConfiguration();
//        System.out.println(propertyConfiguration.getName());


        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.senla.haltvinizki");
        CategoryController categoryController=applicationContext.getBean(CategoryController.class);

        System.out.println(categoryController.createCategory(categoryJson));

        System.out.println(categoryController.readCategory());

//        categoryJson="{\"id\":2,\"name\":\"Food\"}";
//
//        System.out.println(categoryController.updateCategory(categoryJson));
//
//        System.out.println(categoryController.readCategory());
//
//        System.out.println(categoryController.deleteCategory(categoryJson));
//
//        System.out.println(categoryController.readCategory());



    }

}
