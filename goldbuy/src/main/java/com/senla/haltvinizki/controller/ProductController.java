package com.senla.haltvinizki.controller;


import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
@Component
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductInfoDto createProduct(@RequestBody ProductInfoDto productInfoDto) {
        return productService.create(productInfoDto);
    }

    @GetMapping(value = "/{id}")
    public ProductInfoDto getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping
    public ProductInfoDto updateProduct(@RequestBody ProductInfoDto productInfoDto) {
        return productService.update(productInfoDto);

    }

    @DeleteMapping(value = "/{id}")
    public ProductInfoDto deleteProduct(@PathVariable Long id) {
        return productService.delete(id);

    }
}
