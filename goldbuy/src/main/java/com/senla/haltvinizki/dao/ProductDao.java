package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product,Integer>{
    Product getMostExpensiveProduct();

    List<Product> getActiveProducts();

    Product getProductWithUser(int id);

    Product getProductWithCategory(int id);
}
