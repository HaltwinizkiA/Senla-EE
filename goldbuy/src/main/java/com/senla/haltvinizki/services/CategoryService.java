package com.senla.haltvinizki.services;

import com.senla.haltvinizki.dto.CategoryDto;
import com.senla.haltvinizki.entity.category.Category;

public interface CategoryService {
    CategoryDto delete(CategoryDto categoryDao);

    CategoryDto create(CategoryDto categoryDao);

    CategoryDto update(CategoryDto categoryDao);

    CategoryDto getById(int id);

    CategoryDto getCategoryWithProduct(int id);

}
