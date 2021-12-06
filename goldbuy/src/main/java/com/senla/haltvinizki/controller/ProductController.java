package com.senla.haltvinizki.controller;


import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ProductInfoDto createProduct(@RequestBody ProductInfoDto productInfoDto) {
        return productService.create(productInfoDto);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")//todo with obj
    public ProductInfoDto getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")//todo with obj
    public ProductInfoDto updateProduct(@RequestBody ProductInfoDto productInfoDto) {
        return productService.update(productInfoDto);

    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")//todo with obj
    public ProductInfoDto deleteProduct(@PathVariable Long id) {
        return productService.delete(id);

    }
}
