package com.senla.haltvinizki.services;

import com.senla.haltvinizki.dto.category.CategoryInfoDto;
import com.senla.haltvinizki.dto.category.CategoryWithProductDto;

public interface CategoryService {
    CategoryInfoDto delete(CategoryInfoDto categoryDao);

    CategoryInfoDto create(CategoryInfoDto categoryDao);

    CategoryInfoDto update(CategoryInfoDto categoryDao);

    CategoryInfoDto getById(int id);

    CategoryWithProductDto getCategoryWithProduct(int id);

}
