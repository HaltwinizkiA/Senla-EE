package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.services.CategoryService;
import com.senla.haltvinizki.util.Logger;
import org.springframework.stereotype.Component;

@Component
public class CategoryController {

    private CategoryService categoryService;
    private JsonMapper gsonMapper;

    public CategoryController(CategoryService categoryService, JsonMapper gsonMapper) {
        this.categoryService = categoryService;
        this.gsonMapper = gsonMapper;
    }


    public String createCategory(String jsonCategory) {
        try {
            Category category = categoryService.create((Category) gsonMapper.createObj(jsonCategory, Category.class));
            return gsonMapper.createJson(category);

        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "category not created";
        }
    }

    public String getById(int id) {
        return gsonMapper.createJson(categoryService.getById(id));
    }

    public String updateCategory(String jsonCategory) {
        try {
            Category category = categoryService.update((Category) gsonMapper.createObj(jsonCategory, Category.class));
            return gsonMapper.createJson(category);

        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "category not updated";
        }
    }

    public String deleteCategory(String jsonCategory) {
        try {
            Category category = categoryService.delete((Category) gsonMapper.createObj(jsonCategory, Category.class));
            return gsonMapper.createJson(category);

        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "category not deleted";
        }
    }

    public void test() {
        categoryService.test();
    }
}



