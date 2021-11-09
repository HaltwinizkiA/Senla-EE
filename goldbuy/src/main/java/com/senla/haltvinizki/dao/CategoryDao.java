package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.category.Category;


import java.util.List;

public interface CategoryDao {
    Category delete(Category categoryDao);

    Category create(Category categoryDao);

    Category update(Category categoryDao);

    List<Category> read();
}
