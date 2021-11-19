package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.product.Product;

public interface ProductDao extends GenericDao<Product,Integer>{
    Product getMostExpensiveProduct();

    Product getProductWithUser(int id);

    Product getProductWithCategory(int id);
}
