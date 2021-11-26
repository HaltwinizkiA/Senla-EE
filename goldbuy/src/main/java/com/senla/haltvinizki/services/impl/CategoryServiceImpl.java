package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.dto.category.CategoryInfoDto;
import com.senla.haltvinizki.dto.category.CategoryWithProductDto;
import com.senla.haltvinizki.entity.Category;
import com.senla.haltvinizki.services.CategoryService;
import com.senla.haltvinizki.services.converter.CategoryConverter;
import com.senla.haltvinizki.services.exception.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Optional.ofNullable;

@Component
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;
    private final CategoryConverter categoryConverter;


    @Override
    public CategoryInfoDto delete(Long id) {
        return categoryConverter.convert(categoryDao.delete(id));
    }

    @Override
    public CategoryInfoDto create(CategoryInfoDto categoryDto) {
        Category category = categoryConverter.convert(categoryDto);
        return categoryConverter.convert(categoryDao.create(category));
    }


    @Override
    public CategoryInfoDto update(CategoryInfoDto categoryDto) {
        Category category = categoryConverter.convert(categoryDto);
        return categoryConverter.convert(categoryDao.update(category));
    }

    @Override
    public CategoryInfoDto getById(Long id) {
        Category category = ofNullable(categoryDao.getById(id))
                .orElseThrow(() -> new CategoryNotFoundException(id));
        return categoryConverter.convert(category);
    }

    @Override
    public CategoryWithProductDto getCategoryWithProduct(Long id) {
        return categoryConverter.covert(categoryDao.getCategoryWithProduct(id));
    }
}
