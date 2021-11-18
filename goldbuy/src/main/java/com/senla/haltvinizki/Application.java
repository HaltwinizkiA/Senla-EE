package com.senla.haltvinizki;


import com.senla.haltvinizki.controllers.CategoryController;
import com.senla.haltvinizki.controllers.UserController;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.services.CategoryService;
import com.senla.haltvinizki.services.impl.CategoryServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args){
        String categoryJson="{\"name\":\"Furniture\"}";
//        PropertyConfiguration propertyConfiguration=new PropertyConfiguration();
//        System.out.println(propertyConfiguration.getName());

        Category category=new Category(12,"ddddddddd");
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.senla.haltvinizki");

        UserController userController=applicationContext.getBean(UserController.class);
        CategoryController categoryController=applicationContext.getBean(CategoryController.class);
        CategoryService categoryService=applicationContext.getBean(CategoryService.class);
        categoryService.test();
        Category category1=categoryService.getById(1);
        System.out.println("\n \nSSSSSSSSSSSSSSSSSSS"+categoryService.getById(1).toString()+"\n\n");
//        System.out.println(userController.getById(1));


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
