package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.product.Product;
import com.senla.haltvinizki.entity.user.User;

import java.util.List;

public interface ProductDao {
    Product delete(Product product);

    Product create(Product product);

    Product update(Product product);

    List<Product> read();
}
