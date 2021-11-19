package com.senla.haltvinizki.services;

import com.senla.haltvinizki.entity.product.Product;

public interface ProductService {
    Product delete(Product product);

    Product create(Product product);

    Product update(Product product);

    Product getById(int id);

    Product getMostExpensiveProduct();

    Product getProductWithUser(int id);

    Product getProductWithCategory(int id);
}
