package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.entity.product.Product;
import com.senla.haltvinizki.services.ProductService;
import com.senla.haltvinizki.util.Logger;

public class ProductController {

    private final ProductService productService;
    private final JsonMapper gsonMapper;

    public ProductController(ProductService productService, JsonMapper gsonMapper) {
        this.productService = productService;
        this.gsonMapper = gsonMapper;
    }

    public String createProduct(String jsonProduct) {
        try {
            Product product = productService.create((Product) gsonMapper.createObj(jsonProduct, Product.class));
            return gsonMapper.createJson(product);
        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "product not create";

        }
    }

    public String readProduct() {
        return gsonMapper.createJson(productService.read());
    }

    public String updateProduct(String jsonProduct) {
        try {
            Product product = productService.update((Product) gsonMapper.createObj(jsonProduct, Product.class));
            return gsonMapper.createJson(product);
        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "product not update";

        }
    }

    public String deleteProduct(String jsonProduct) {
        try {
            Product product = productService.delete((Product) gsonMapper.createObj(jsonProduct, Product.class));
            return gsonMapper.createJson(product);
        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "product not delete";

        }
    }
}
