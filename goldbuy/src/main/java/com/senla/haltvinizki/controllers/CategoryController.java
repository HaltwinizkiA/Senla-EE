package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.GsonMapper;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.services.CategoryService;
import com.senla.haltvinizki.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    GsonMapper gsonMapper;

    public CategoryController(CategoryService categoryService, GsonMapper gsonMapper) {
        this.categoryService = categoryService;
        this.gsonMapper = gsonMapper;
    }

    public String createCategory(String jsonCategory) {
        Category category = categoryService.create((Category) gsonMapper.createObj(jsonCategory, Category.class));
        return gsonMapper.createJson(category);
    }

    public String readCategory() {
        return gsonMapper.createJson(categoryService.read());
    }

    public String updateCategory(String jsonCategory) {
        Category category = categoryService.update((Category) gsonMapper.createObj(jsonCategory, Category.class));
        return gsonMapper.createJson(category);
    }

    public String deleteCategory(String jsonCategory) {
        Category category = categoryService.delete((Category) gsonMapper.createObj(jsonCategory, Category.class));
        return gsonMapper.createJson(category);
    }
}



