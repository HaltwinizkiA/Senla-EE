package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.category.CategoryInfoDto;

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
            CategoryInfoDto categoryDto = categoryService.create((CategoryInfoDto) gsonMapper.createObj(jsonCategory, CategoryInfoDto.class));
            return gsonMapper.createJson(categoryDto);
        } catch (JsonProcessingException e) {

            return "category not created";
        }
    }

    public String getById(int id) {
        return gsonMapper.createJson(categoryService.getById(id));
    }

    public String updateCategory(String jsonCategory) {
        try {
            CategoryInfoDto categoryDto = categoryService.update((CategoryInfoDto) gsonMapper.createObj(jsonCategory, CategoryInfoDto.class));
            return gsonMapper.createJson(categoryDto);

        } catch (JsonProcessingException e) {
            return "category not updated";
        }
    }

    public String deleteCategory(String jsonCategory) {
        try {
            CategoryInfoDto categoryDto = categoryService.delete((CategoryInfoDto) gsonMapper.createObj(jsonCategory, CategoryInfoDto.class));
            return gsonMapper.createJson(categoryDto);

        } catch (JsonProcessingException e) {
            return "category not deleted";
        }
    }


}



