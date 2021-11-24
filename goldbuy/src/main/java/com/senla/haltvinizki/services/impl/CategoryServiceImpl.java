package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.dto.category.CategoryInfoDto;
import com.senla.haltvinizki.dto.category.CategoryWithProductDto;
import com.senla.haltvinizki.entity.Category;
import com.senla.haltvinizki.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;
    @Autowired
    private ModelMapper mapper;


    @Override
    @Transactional
    public CategoryInfoDto delete(CategoryInfoDto categoryDto) {
        return mapper.map(categoryDao.delete(categoryDto.getId()), CategoryInfoDto.class);
    }

    @Override
    @Modifying
    @Transactional
    public CategoryInfoDto create(CategoryInfoDto categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);
        return mapper.map(categoryDao.create(category), CategoryInfoDto.class);
    }


    @Override
    @Transactional
    public CategoryInfoDto update(CategoryInfoDto categoryDto) {
        Category category = mapper.map(categoryDto, Category.class);
        return mapper.map(categoryDao.update(category), CategoryInfoDto.class);
    }

    @Override
    public CategoryInfoDto getById(int id) {
        Category category = categoryDao.getById(id);
        return mapper.map(category, CategoryInfoDto.class);
    }

    @Override
    public CategoryWithProductDto getCategoryWithProduct(int id) {
        Category category = categoryDao.getCategoryWithProduct(id);
        return mapper.map(category, CategoryWithProductDto.class);
    }
}
