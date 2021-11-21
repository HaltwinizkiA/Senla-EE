package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.CategoryDto;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.services.CategoryService;

import org.springframework.stereotype.Component;

@Component
public class CategoryController {

    private final CategoryService categoryService;
    private final JsonMapper gsonMapper;

    public CategoryController(CategoryService categoryService, JsonMapper gsonMapper) {
        this.categoryService = categoryService;
        this.gsonMapper = gsonMapper;
    }


    public String createCategory(String jsonCategory) {
        try {
            CategoryDto category = categoryService.create((CategoryDto) gsonMapper.createObj(jsonCategory, Category.class));
            return gsonMapper.createJson(category);
        } catch (JsonProcessingException e) {

            return "category not created";
        }
    }

    public String getById(int id) {
        return gsonMapper.createJson(categoryService.getById(id));
    }

    public String updateCategory(String jsonCategory) {
        try {
            CategoryDto category = categoryService.update((CategoryDto) gsonMapper.createObj(jsonCategory, Category.class));
            return gsonMapper.createJson(category);

        } catch (JsonProcessingException e) {
            return "category not updated";
        }
    }

    public String deleteCategory(String jsonCategory) {
        try {
            CategoryDto category = categoryService.delete((CategoryDto) gsonMapper.createObj(jsonCategory, Category.class));
            return gsonMapper.createJson(category);

        } catch (JsonProcessingException e) {
            return "category not deleted";
        }
    }


}



