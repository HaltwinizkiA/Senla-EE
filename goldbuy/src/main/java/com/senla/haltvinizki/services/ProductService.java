package com.senla.haltvinizki.services;

import com.senla.haltvinizki.entity.product.Product;

import java.util.List;

public interface ProductService {
    Product delete(Product product);

    Product create(Product product);

    Product update(Product product);

    List<Product> read();
}
