package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.category.CategoryInfoDto;

import com.senla.haltvinizki.services.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final JsonMapper gsonMapper;
    @PostMapping
    public String createCategory(@RequestBody String jsonCategory) {
        try {
            CategoryInfoDto categoryDto = categoryService.create((CategoryInfoDto) gsonMapper.createObj(jsonCategory, CategoryInfoDto.class));
            return gsonMapper.createJson(categoryDto);
        } catch (JsonProcessingException e) {

            return "category not created";
        }
    }
    @GetMapping(value = "/{id}")
    public CategoryInfoDto getById(@PathVariable int id) {
        return categoryService.getById(id);
    }
    @PutMapping
    public String updateCategory(@RequestBody String jsonCategory) {
        try {
            CategoryInfoDto categoryDto = categoryService.update((CategoryInfoDto) gsonMapper.createObj(jsonCategory, CategoryInfoDto.class));
            return gsonMapper.createJson(categoryDto);

        } catch (JsonProcessingException e) {
            return "category not updated";
        }
    }
    @DeleteMapping(value = "/{id}")
    public String deleteCategory(@RequestBody String jsonCategory) {
        try {
            CategoryInfoDto categoryDto = categoryService.delete((CategoryInfoDto) gsonMapper.createObj(jsonCategory, CategoryInfoDto.class));
            return gsonMapper.createJson(categoryDto);

        } catch (JsonProcessingException e) {
            return "category not deleted";
        }
    }


}



