package com.senla.haltvinizki.services;

import com.senla.haltvinizki.entity.category.Category;

public interface CategoryService {
    Category delete(Category categoryDao);

    Category create(Category categoryDao);

    Category update(Category categoryDao);

    Category getById(int id);

    Category getCategoryWithProduct(int id);

}
