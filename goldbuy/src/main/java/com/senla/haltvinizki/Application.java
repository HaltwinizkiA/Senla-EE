package com.senla.haltvinizki;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
import com.senla.haltvinizki.controllers.CategoryController;
import com.senla.haltvinizki.controllers.UserController;

import com.senla.haltvinizki.entity.category.Category;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args) throws URISyntaxException, JsonProcessingException {
        String categoryJson="{\"id\":2,\"name\":\"Furniture\"}";
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.senla.haltvinizki");
        CategoryController categoryController=applicationContext.getBean(CategoryController.class);

        System.out.println(categoryController.createCategory(categoryJson));

        System.out.println(categoryController.readCategory());

        categoryJson="{\"id\":2,\"name\":\"Food\"}";

        System.out.println(categoryController.updateCategory(categoryJson));

        System.out.println(categoryController.readCategory());

        System.out.println(categoryController.deleteCategory(categoryJson));

        System.out.println(categoryController.readCategory());



    }

}
