package com.senla.haltvinizki;


import com.senla.haltvinizki.dto.CategoryDto;
import com.senla.haltvinizki.dto.CredentialsDto;
import com.senla.haltvinizki.entity.credentials.Credentials;
import com.senla.haltvinizki.entity.history.History;
import com.senla.haltvinizki.services.CategoryService;
import com.senla.haltvinizki.services.CredentialsService;
import com.senla.haltvinizki.services.HistoryService;
import com.senla.haltvinizki.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        String categoryJson = "{\"name\":\"Furniture\"}";

//        Category category=new Category(12,"ddddddddd");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.senla.haltvinizki");


        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
        CategoryDto category = categoryService.getById(1);
        CategoryDto category1=categoryService.getCategoryWithProduct(1);
        HistoryService historyService=applicationContext.getBean(HistoryService.class);

        History history=historyService.getById(1);
        History history1=historyService.getHistoryWithCustomer(3);
        History history2=historyService.getHistoryWithProduct(1);
//

        UserService userService = applicationContext.getBean(UserService.class);
//        User user1 = userService.getUserWithLogin("user");
//        List<User> userList=userService.getAllAdmin();
//        User user2=userService.getUserWithCredentials(1);
//        User user3=userService.getUserWithProducts(1);
//        User user4=userService.getUserWithRole(1);
//

//        RoleService roleService = applicationContext.getBean(RoleService.class);
//        Role role = roleService.getById(1);
//        Role role1=roleService.getRoleWithUsers(1);
//

//        HistoryService historyService=applicationContext.getBean(HistoryService.class);
//        History history=historyService.getById(1);
//        History history1=historyService.getHistoryWithCustomer(3);
//        History history2=historyService.getHistoryWithProduct(1);
//

//        ProductService productService = applicationContext.getBean(ProductService.class);
//        List<Product> products=productService.getActiveProducts();
//        Product product = productService.getById(1);
//        Product product1=productService.getProductWithCategory(1);
//        Product product2=productService.getProductWithUser(1);
//

//        ProductConfigurationService productConfigurationService = applicationContext.getBean(ProductConfigurationService.class);
//        ProductConfiguration productConfiguration = productConfigurationService.getById(1);
//        ProductConfiguration productConfiguration1=productConfigurationService.getProductConfigWithProduct(2);
//

        CredentialsService credentialsService = applicationContext.getBean(CredentialsService.class);
        CredentialsDto credentials1=credentialsService.getCredentialsWithUser(1);
        CredentialsDto credentials = credentialsService.getById(1);

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
