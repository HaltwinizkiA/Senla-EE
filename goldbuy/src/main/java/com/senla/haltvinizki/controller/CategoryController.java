package com.senla.haltvinizki.controller;


import com.senla.haltvinizki.dto.category.CategoryInfoDto;
import com.senla.haltvinizki.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @Secured("ROLE_ADMIN")
    public CategoryInfoDto createCategory(@RequestBody CategoryInfoDto categoryInfoDto) {
        return categoryService.create(categoryInfoDto);
    }

    @GetMapping(value = "/{id}")
    @Secured({"ROLE_ADMIN","User"})
    public CategoryInfoDto getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PutMapping
    @Secured("ROLE_ADMIN")
    public CategoryInfoDto updateCategory(@RequestBody CategoryInfoDto categoryInfoDto) {
        return categoryService.update(categoryInfoDto);
    }

    @DeleteMapping(value = "/{id}")
    @Secured("ROLE_ADMIN")
    public CategoryInfoDto deleteCategory(@PathVariable Long id) {
        return categoryService.delete(id);

    }


}



