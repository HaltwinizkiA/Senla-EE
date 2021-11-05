package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.impl.CategoryDaoImpl;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CategoryServiceImpl implements CategoryService {

    public CategoryServiceImpl(CategoryDaoImpl categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Autowired
    private CategoryDaoImpl categoryDao;


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
    public List<Category> read() {
        return categoryDao.read();
    }
}
