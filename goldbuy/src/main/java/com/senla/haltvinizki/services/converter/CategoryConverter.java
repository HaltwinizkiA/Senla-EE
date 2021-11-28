package com.senla.haltvinizki.services.converter;

import com.senla.haltvinizki.dto.category.CategoryInfoDto;
import com.senla.haltvinizki.dto.category.CategoryWithProductDto;
import com.senla.haltvinizki.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    @Autowired
    private ModelMapper mapper;

    public Category convert(CategoryInfoDto categoryInfoDto) {
        return mapper.map(categoryInfoDto, Category.class);
    }

    public CategoryInfoDto convert(Category category) {
        return mapper.map(category, CategoryInfoDto.class);
    }

    public Category convert(CategoryWithProductDto categoryWithProductDto) {
        return mapper.map(categoryWithProductDto, Category.class);
    }

    public CategoryWithProductDto covert(Category category) {
        return mapper.map(category, CategoryWithProductDto.class);
    }
}
