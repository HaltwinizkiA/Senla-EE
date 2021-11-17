package com.senla.haltvinizki;


import com.senla.haltvinizki.controllers.CategoryController;
import com.senla.haltvinizki.controllers.UserController;
import com.senla.haltvinizki.dao.configuration.DataBaseConfiguration;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.services.CategoryService;
import com.senla.haltvinizki.services.impl.CategoryServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args){
        DataBaseConfiguration dataBaseConfiguration=new DataBaseConfiguration();
        String categoryJson="{\"name\":\"Furniture\"}";
//        PropertyConfiguration propertyConfiguration=new PropertyConfiguration();
//        System.out.println(propertyConfiguration.getName());

        Category category=new Category(12,"ddddddddd");
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.senla.haltvinizki");

        UserController userController=applicationContext.getBean(UserController.class);
        CategoryController categoryService=applicationContext.getBean(CategoryController.class);
        categoryService.test();
        System.out.println("SSSSSSSSSSSSSSSSSSS"+categoryService.getById(1));
        System.out.println(userController.getById(1));


//        categoryController.transTest(category);
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
