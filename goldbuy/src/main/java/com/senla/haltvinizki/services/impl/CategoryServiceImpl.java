package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;




@Component
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override

    public Category delete(Category category) {
        return categoryDao.delete(category);
    }

    @Override
    public Category create(Category category) {
        return categoryDao.create(category);
    }


    @Override
    public Category update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public Category getById(int id) {
        return categoryDao.getById(id);
    }
    @Override
    public void test(){
        System.out.println("ASDASDASDASDDDDDDDDDDDDDDDDDDDASDASD");
    }
}
