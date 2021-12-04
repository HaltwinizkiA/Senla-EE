package com.senla.haltvinizki.controller;


import com.senla.haltvinizki.dto.category.CategoryInfoDto;
import com.senla.haltvinizki.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CategoryInfoDto createCategory(@RequestBody CategoryInfoDto categoryInfoDto) {
        return categoryService.create(categoryInfoDto);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public CategoryInfoDto getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CategoryInfoDto updateCategory(@RequestBody CategoryInfoDto categoryInfoDto) {
        return categoryService.update(categoryInfoDto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CategoryInfoDto deleteCategory(@PathVariable Long id) {
        return categoryService.delete(id);

    }


}



