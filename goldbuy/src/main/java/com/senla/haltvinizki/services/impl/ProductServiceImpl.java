package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.ProductDao;
import com.senla.haltvinizki.entity.product.Product;
import com.senla.haltvinizki.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductDao productDao;

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
    public Product getById(int id) {
        return productDao.getById(id);
    }

    @Override
    public Product getMostExpensiveProduct() {
        return productDao.getMostExpensiveProduct();
    }

    @Override
    public Product getProductWithUser(int id) {
        return productDao.getProductWithUser(id);
    }

    @Override
    public Product getProductWithCategory(int id) {
        return productDao.getProductWithCategory(id);
    }
}
