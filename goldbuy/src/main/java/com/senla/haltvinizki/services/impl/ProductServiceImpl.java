package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.ProductDao;
import com.senla.haltvinizki.entity.product.Product;
import com.senla.haltvinizki.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductDao productDao;


    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product delete(Product product) {
        return productDao.delete(product);
    }

    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public List<Product> read() {
        return productDao.read();
    }
}
