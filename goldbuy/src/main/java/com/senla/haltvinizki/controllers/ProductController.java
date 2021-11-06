package com.senla.haltvinizki.controllers;


import com.senla.haltvinizki.controllers.mapper.GsonMapper;
import com.senla.haltvinizki.entity.product.Product;
import com.senla.haltvinizki.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    GsonMapper gsonMapper;

    public ProductController(ProductService productService, GsonMapper gsonMapper) {
        this.productService = productService;
        this.gsonMapper = gsonMapper;
    }

    public String createProduct(String jsonProduct) {
        Product product = productService.create((Product) gsonMapper.createObj(jsonProduct, Product.class));
        return gsonMapper.createJson(product);
    }

    public String readProduct() {
        return gsonMapper.createJson(productService.read());
    }

    public String updateProduct(String jsonProduct) {
        Product product = productService.update((Product) gsonMapper.createObj(jsonProduct, Product.class));
        return gsonMapper.createJson(product);
    }

    public String deleteProduct(String jsonProduct) {
        Product product = productService.delete((Product) gsonMapper.createObj(jsonProduct, Product.class));
        return gsonMapper.createJson(product);
    }
}
