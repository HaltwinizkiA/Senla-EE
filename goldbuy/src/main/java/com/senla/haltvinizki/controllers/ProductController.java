package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.services.ProductService;

public class ProductController {

    private final ProductService productService;
    private final JsonMapper gsonMapper;

    public ProductController(ProductService productService, JsonMapper gsonMapper) {
        this.productService = productService;
        this.gsonMapper = gsonMapper;
    }

    public String createProduct(String jsonProduct) {
        try {
            ProductInfoDto productDto = productService.create((ProductInfoDto) gsonMapper.createObj(jsonProduct, ProductInfoDto.class));
            return gsonMapper.createJson(productDto);
        } catch (JsonProcessingException e) {
            return "product not create";

        }
    }

    public String getById(int id) {
        return gsonMapper.createJson(productService.getById(id));
    }

    public String updateProduct(String jsonProduct) {
        try {
            ProductInfoDto productDto = productService.update((ProductInfoDto) gsonMapper.createObj(jsonProduct, ProductInfoDto.class));
            return gsonMapper.createJson(productDto);
        } catch (JsonProcessingException e) {
            return "product not update";

        }
    }

    public String deleteProduct(String jsonProduct) {
        try {
            ProductInfoDto productDto = productService.delete((ProductInfoDto) gsonMapper.createObj(jsonProduct, ProductInfoDto.class));
            return gsonMapper.createJson(productDto);
        } catch (JsonProcessingException e) {
            return "product not delete";

        }
    }
}
