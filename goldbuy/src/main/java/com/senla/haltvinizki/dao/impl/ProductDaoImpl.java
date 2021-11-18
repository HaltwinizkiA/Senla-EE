package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.ProductDao;
import com.senla.haltvinizki.entity.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDaoImpl extends AbstractDao<Product, Integer> implements ProductDao {
    public ProductDaoImpl() {
        super(Product.class);
    }

}
