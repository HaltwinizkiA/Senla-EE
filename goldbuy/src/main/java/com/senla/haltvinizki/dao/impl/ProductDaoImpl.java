package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.ProductDao;
import com.senla.haltvinizki.entity.product.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {
    List<Product> productList;

    public ProductDaoImpl() {
        this.productList = new ArrayList<>();
        productList.add(new Product(0,"Toyota",new Date(),0,0,"active",6444));
        productList.add(new Product(1,"Oral-B",new Date(),1,1,"active",345));
    }

    @Override
    public Product delete(Product product) {
        productList.removeIf(soughtProduct -> soughtProduct.getId() == product.getId());
        return product;
    }

    @Override
    public Product create(Product product) {
        productList.add(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        for (Product soughtProduct : read()) {
            if (soughtProduct.getId() == product.getId()) {
                productList.remove(soughtProduct);
                productList.add(product);
            }
        }
        return product;
    }

    @Override
    public List<Product> read() {
        return productList;
    }
}
