package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.annotation.Transactional;
import com.senla.haltvinizki.dao.impl.JDBCCategoryDaoImpl;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Transactional
@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final JDBCCategoryDaoImpl categoryDao;

    public CategoryServiceImpl(JDBCCategoryDaoImpl categoryDao) {

        this.categoryDao = categoryDao;
    }

    @Override
    @Transactional
    public Category delete(Category category) {
        return categoryDao.delete(category);
    }

    @Override
    @Transactional
    public Category create(Category category) {
        return categoryDao.create(category);
    }

    @Override
    @Transactional
    public void runtimeTest(Category category) {
        categoryDao.create(category);
        throw new RuntimeException();
    }

    @Override
    @Transactional
    public Category update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    @Transactional
    public List<Category> read() {
        return categoryDao.read();
    }
}
