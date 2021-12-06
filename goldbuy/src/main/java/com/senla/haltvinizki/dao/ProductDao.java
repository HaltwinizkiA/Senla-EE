package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product,Long>{
    Product getMostExpensiveProduct();

    List<Product> getActiveProducts();

    Product getProductWithUser(Long id);

    Product getProductWithCategory(Long id);

    List<Product> getByUserId(long id);
}
