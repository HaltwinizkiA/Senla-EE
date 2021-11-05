package com.senla.haltvinizki.services;

import com.senla.haltvinizki.entity.category.Category;

import java.util.List;

public interface CategoryService {
    Category delete(Category categoryDao);

    Category create(Category categoryDao);

    Category update(Category categoryDao);

    List<Category> read();
}
