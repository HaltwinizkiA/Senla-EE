package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.configuration.DatabaseConfig;
import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.dao.ProductDao;
import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.entity.Category;
import com.senla.haltvinizki.entity.Credentials;
import com.senla.haltvinizki.entity.Product;
import com.senla.haltvinizki.entity.User;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {DatabaseConfig.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductDaoImplTest extends TestCase {
    private final float price = 200;
    private final Date date = new Date();
    @Resource
    ProductDao productDao;
    @Resource
    CategoryDao categoryDao;
    @Resource
    UserDao userDao;
    @Resource
    CredentialsDao credentialsDao;

    @Before
    public void fillingTable() {
        userDao.create(User.builder().credentials(Credentials.builder().user(User.builder().build()).login("login").build()).name("oleg").build());
        credentialsDao.create(Credentials.builder().user(User.builder().id(1L).build()).login("login").build());
        categoryDao.create(Category.builder().name("phones").build());
        Product product = Product.builder()
                .category(Category.builder().id(1L).name("phones").build())
                .user(User.builder().id(1L).name("oleg").build())
                .status("active").price(price).name("iphone").addedDate(date).build();
        Product product2 = Product.builder()
                .category(Category.builder().id(2L).name("cars").build())
                .user(User.builder().id(2L).name("Luk").build())
                .status("active").price(2000).name("audi").addedDate(date).build();
        Product product3 = Product.builder()
                .category(Category.builder().id(3L).name("shoes").build())
                .user(User.builder().id(3L).name("John").build())
                .price(price).name("sneaker").addedDate(date).build();
        productDao.create(product);
        productDao.create(product2);
        productDao.create(product3);
    }

    @Test
    public void create() {
        Product product = Product.builder()
                .category(Category.builder().id(4L).name("wheels").build())
                .user(User.builder().id(4L).name("kiril").build())
                .price(price).name("belshina").addedDate(date).build();
        Product product1 = productDao.getById(4L);
        assertEquals(4L, product1.getId());
        assertEquals(product.getPrice(), product1.getPrice());
        assertEquals(product.getAddedDate(), product1.getAddedDate());
        assertEquals(product.getName(), product1.getName());
    }

    @Test
    public void getById() {
        Product product = productDao.getById(1L);
        assertEquals(1L, product.getId());
        assertEquals(price, product.getPrice());
        assertEquals("iphone", product.getName());
        assertEquals(date, product.getAddedDate());
    }

    @Test
    public void update() {
        Product product = productDao.getById(2L);
        product.setName("mercedes");
        productDao.update(product);
        Product product1=productDao.getById(2L);
        assertEquals(2L, product1.getId());
        assertEquals("mercedes", product1.getName());

    }

    @Test
    public void delete() {
        productDao.delete(3L);
        assertNull(productDao.getById(3L));
    }

    @Test
    public void getProductWithUser() {
        Product product = productDao.getProductWithUser(1L);
        assertEquals(1L, product.getId());
        assertEquals("iphone", product.getName());
        assertEquals(1L, product.getUser().getId());
        assertEquals("oleg", product.getUser().getName());
    }

    @Test
    public void getProductWithCategory() {
        Product product = productDao.getProductWithCategory(1L);
        assertEquals(1L, product.getId());
        assertEquals("iphone", product.getName());
        assertEquals(1L, product.getCategory().getId());
        assertEquals("phones", product.getCategory().getName());
    }
    @Test
    public void getMostExpensiveProduct() {
        Product product = productDao.getMostExpensiveProduct();
        assertEquals(2L, product.getId());
        assertEquals("audi", product.getName());
        assertEquals(2000, product.getPrice());
    }
    @Test
    public void getActiveProducts() {
        List<Product> productList = productDao.getActiveProducts();
        System.out.println();
//        assertEquals(2L, product.getId());
//        assertEquals("audi", product.getName());
//        assertEquals(2000, product.getPrice());
    }

}