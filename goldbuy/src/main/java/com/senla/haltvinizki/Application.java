package com.senla.haltvinizki;


import com.senla.haltvinizki.dto.category.CategoryInfoDto;
import com.senla.haltvinizki.dto.category.CategoryWithProductDto;
import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import com.senla.haltvinizki.dto.credentials.CredentialsWithUserDto;
import com.senla.haltvinizki.dto.history.HistoryInfoDto;
import com.senla.haltvinizki.dto.history.HistoryWithCustomerDto;
import com.senla.haltvinizki.dto.history.HistoryWithProductDto;
import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.dto.product.ProductWithCategoryDto;
import com.senla.haltvinizki.dto.product.ProductWithUserDto;
import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.dto.user.UserWithCredentialsDto;
import com.senla.haltvinizki.dto.user.UserWithProductsDto;
import com.senla.haltvinizki.dto.user.UserWithRolesDto;
import com.senla.haltvinizki.services.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String categoryJson = "{\"name\":\"Furniture\"}";

//        Category category=new Category(12,"ddddddddd");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.senla.haltvinizki");
//
////
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
        CategoryInfoDto category = categoryService.getById(1);
        CategoryWithProductDto category1=categoryService.getCategoryWithProduct(1);
//
        HistoryService historyService=applicationContext.getBean(HistoryService.class);
        HistoryInfoDto history=historyService.getById(1);
        HistoryWithCustomerDto history1=historyService.getHistoryWithCustomer(3);
        HistoryWithProductDto history2=historyService.getHistoryWithProduct(1);
//
        CredentialsService credentialsService = applicationContext.getBean(CredentialsService.class);

        CredentialsInfoDto credentials = credentialsService.getById(1);
        CredentialsWithUserDto credentials1=credentialsService.getCredentialsWithUser(1);
////
//
        UserService userService = applicationContext.getBean(UserService.class);
        UserInfoDto user1 = userService.getUserWithLogin("user");
        List<UserInfoDto> userList=userService.getAllAdmin();
        UserWithCredentialsDto user2=userService.getUserWithCredentials(1);
        UserWithProductsDto user3=userService.getUserWithProducts(1);
        UserWithRolesDto user4=userService.getUserWithRole(1);
//

        RoleService roleService = applicationContext.getBean(RoleService.class);
//        RoleInfoDto role = roleService.getById(1);
//        RoleWitUsersDto role1=roleService.getRoleWithUsers(1);
////
        ProductService productService = applicationContext.getBean(ProductService.class);
        ProductInfoDto product = productService.getById(1);
        List<ProductInfoDto> products=productService.getActiveProducts();
        ProductWithCategoryDto product1=productService.getProductWithCategory(1);
        ProductWithUserDto product2=productService.getProductWithUser(1);
////
//
//        ProductConfigurationService productConfigurationService = applicationContext.getBean(ProductConfigurationService.class);
//        ProductConfigurationInfoDto productConfiguration = productConfigurationService.getById(1);
//        ProductConfigurationWithProductDto productConfiguration1=productConfigurationService.getProductConfigWithProduct(1);
//



//

//        categoryController.transTest(category);
//        System.out.println(categoryController.createCategory(categoryJson));
//

//        System.out.println(categoryController.readCategory());
//
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
