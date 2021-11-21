package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.dto.CategoryDto;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.services.CategoryService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;

    }

    @Override
    public CategoryDto delete(CategoryDto categoryDto) {
        Category category = Category.builder().name(categoryDto.getName()).build();
        return CategoryDto.builder().name(categoryDao.delete(category).getName()).build();
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = Category.builder().name(categoryDto.getName()).build();
        return CategoryDto.builder().name(categoryDao.create(category).getName()).build();
    }


    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        Category category = Category.builder().name(categoryDto.getName()).build();
        return CategoryDto.builder().name(categoryDao.update(category).getName()).build();
    }

    @Override
    public CategoryDto getById(int id) {
        Category category = categoryDao.getById(id);
        return CategoryDto.builder().name(category.getName()).build();
    }


    @Override
    public CategoryDto getCategoryWithProduct(int id) {
        Category category = categoryDao.getCategoryWithProduct(id);
        return CategoryDto.builder().name(category.getName()).build();

    }
}
