package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.configuration.DatabaseConfig;
import com.senla.haltvinizki.dao.ProductDao;
import com.senla.haltvinizki.entity.Category;
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

    @Before
    public void fillingTable() {
        Product product = Product.builder()
                .category(Category.builder().id(1L).name("phones").build())
                .user(User.builder().id(1L).name("oleg").build())
                .price(price).name("iphone").addedDate(date).build();
        Product product2 = Product.builder()
                .category(Category.builder().id(2L).name("cars").build())
                .user(User.builder().id(2L).name("Luk").build())
                .price(price).name("audi").addedDate(date).build();
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
//
//    @Test
//    public void update() {
//        ProductConfiguration productConfiguration = productDao.getById(2L);
//        productConfiguration.setFrequency(12345);
//        productDao.update(productConfiguration);
//        assertEquals(2L, productConfiguration.getId());
//        assertEquals(maxPrice, productConfiguration.getMaxPrice());
//        assertEquals(minPrice, productConfiguration.getMinPrice());
//        assertEquals(12345, productConfiguration.getFrequency());
//    }
//
//    @Test
//    public void delete() {
//        productDao.delete(3L);
//        assertNull(productDao.getById(3L));
//    }
//
//    @Test
//    public void getProductConfigWithProduct() {
//        ProductConfiguration productConfiguration = productDao.getProductConfigWithProduct(1L);
//        assertEquals(1L, productConfiguration.getId());
//        assertEquals(1L, productConfiguration.getProduct().getId());
//        assertEquals("iphone", productConfiguration.getProduct().getName());
//        assertEquals(maxPrice, productConfiguration.getMaxPrice());
//        assertEquals(minPrice, productConfiguration.getMinPrice());
//    }

}