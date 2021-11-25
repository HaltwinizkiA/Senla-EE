package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
@Component
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final JsonMapper gsonMapper;

    @PostMapping
    public String createProduct(String jsonProduct) {
        try {
            ProductInfoDto productDto = productService.create((ProductInfoDto) gsonMapper.createObj(jsonProduct, ProductInfoDto.class));
            return gsonMapper.createJson(productDto);
        } catch (JsonProcessingException e) {
            return "product not create";

        }
    }

    @GetMapping(value = "/{id}")
    public String getById(int id) {
        return gsonMapper.createJson(productService.getById(id));
    }

    @PutMapping
    public String updateProduct(String jsonProduct) {
        try {
            ProductInfoDto productDto = productService.update((ProductInfoDto) gsonMapper.createObj(jsonProduct, ProductInfoDto.class));
            return gsonMapper.createJson(productDto);
        } catch (JsonProcessingException e) {
            return "product not update";

        }
    }

    @DeleteMapping(value = "/{id}")
    public String deleteProduct(String jsonProduct) {
        try {
            ProductInfoDto productDto = productService.delete((ProductInfoDto) gsonMapper.createObj(jsonProduct, ProductInfoDto.class));
            return gsonMapper.createJson(productDto);
        } catch (JsonProcessingException e) {
            return "product not delete";

        }
    }
}
