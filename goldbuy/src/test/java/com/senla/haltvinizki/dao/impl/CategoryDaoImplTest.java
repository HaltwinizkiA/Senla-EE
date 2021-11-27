package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.configuration.HibernateConf;
import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.dto.category.CategoryInfoDto;
import com.senla.haltvinizki.entity.Category;
import com.senla.haltvinizki.services.CategoryService;
import com.senla.haltvinizki.services.exception.CategoryNotFoundException;
import junit.framework.TestCase;
import org.checkerframework.checker.units.qual.C;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConf.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class CategoryDaoImplTest  extends TestCase {
    @Resource
    CategoryDao categoryDao;


    @Test
   public void getCategoryWithProduct() {

    }
    @Test
    public void create() {
        Category category=new Category();
        category.setName("phone");
        categoryDao.create(category);
        Category category1=categoryDao.getById(1L);
        assertEquals(1L,category1.getId());
        assertEquals("phone",category1.getName());

    }
    @Test
    public void getById() {
        Category category=new Category();
        category.setName("phone");
        categoryDao.create(category);
        Category category1=categoryDao.getById(1L);
        assertEquals(1L,category1.getId());
        assertEquals("phone",category1.getName());

    }
    @Test
    public void update() {
        Category category=new Category();
        category.setName("phone");
        categoryDao.create(category);
        Category category1=categoryDao.getById(1L);
        assertEquals(1L,category1.getId());
        assertEquals("phone",category1.getName());
        category1.setName("car");
        categoryDao.update(category1);
        Category category2=categoryDao.getById(1L);
        assertEquals(1L,category2.getId());
        assertEquals("car",category2.getName());
    }
    @Test
    public void delete() {
        Category category=new Category();
        category.setName("auto");
        categoryDao.create(category);
        assertEquals("auto",categoryDao.getById(1L).getName());
        categoryDao.delete(1L);
        try {
            categoryDao.getById(1L);
        }catch (CategoryNotFoundException e) {
            assertEquals(Long.valueOf(1L),e.getId());
        }
    }
}