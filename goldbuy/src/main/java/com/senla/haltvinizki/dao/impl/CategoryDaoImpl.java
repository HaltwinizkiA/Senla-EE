package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.entity.category.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CategoryDaoImpl implements CategoryDao {
   private List<Category> categoryList;

    public CategoryDaoImpl() {
        this.categoryList = new ArrayList<>();
        categoryList.add(new Category(0, "Car"));
        categoryList.add(new Category(0, "Health"));
    }

    @Override
    public Category delete(Category category) {
        categoryList.removeIf(soughtCategory -> soughtCategory.getId() == category.getId());
        return category;
    }

    @Override
    public Category create(Category category) {
        categoryList.add(category);
        return category;
    }

    @Override
    public Category update(Category category) {
        for (Category soughtCategory : read()) {
            if (soughtCategory.getId() == category.getId()) {
                categoryList.remove(soughtCategory);
                categoryList.add(category);
            }
        }
        return category;
    }

    @Override
    public List<Category> read() {
        return categoryList;
    }
}