package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.dao.GenerikDao;
import com.senla.haltvinizki.entity.category.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CategoryDaoImpl extends AbstractDao<Category, Long> implements CategoryDao {
    public CategoryDaoImpl() {

    }


}