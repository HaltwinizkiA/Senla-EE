package com.senla.haltvinizki;


import com.senla.haltvinizki.controllers.CategoryController;

import com.senla.haltvinizki.entity.category.Category;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args){

        String categoryJson="{\"name\":\"Furniture\"}";
//        PropertyConfiguration propertyConfiguration=new PropertyConfiguration();
//        System.out.println(propertyConfiguration.getName());

        Category category=new Category(12,"ddddddddd");
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.senla.haltvinizki");
        CategoryController categoryController=applicationContext.getBean(CategoryController.class);

        categoryController.transTest(category);
//        System.out.println(categoryController.createCategory(categoryJson));
//
//        System.out.println(categoryController.readCategory());

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
