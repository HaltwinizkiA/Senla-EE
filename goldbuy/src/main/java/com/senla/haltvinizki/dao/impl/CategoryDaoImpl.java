package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.entity.category.Category;
import org.springframework.stereotype.Component;


@Component
public class CategoryDaoImpl extends AbstractDao<Category, Integer> implements CategoryDao {

    public CategoryDaoImpl() {
        super(Category.class);
    }
}

