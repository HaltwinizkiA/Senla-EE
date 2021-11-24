package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.configuration.HibernateConf;
import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.entity.Category;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConf.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
@DirtiesContext
public class CategoryDaoImplTest extends TestCase {

    @Resource
    private CategoryDao categoryDao;

    @Test
    public void createCategory() {
        Category category = new Category();
        category.setId(1);
        category.setName("phone");
        categoryDao.create(category);
        Category category1 = categoryDao.getById(1);
        System.out.println("\n\n"+category1+"\n\n");
        assertEquals("phone", category1.getName());

    }

}