package com.senla.haltvinizki.service;

import com.senla.haltvinizki.dto.category.CategoryInfoDto;
import com.senla.haltvinizki.dto.category.CategoryWithProductDto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CategoryService {
    CategoryInfoDto delete(Long id);

    CategoryInfoDto create(CategoryInfoDto categoryDao);

    CategoryInfoDto update(CategoryInfoDto categoryDao);

    CategoryInfoDto getById(Long id);

    CategoryWithProductDto getCategoryWithProduct(Long id);

    CategoryInfoDto getByName(String name);
}
