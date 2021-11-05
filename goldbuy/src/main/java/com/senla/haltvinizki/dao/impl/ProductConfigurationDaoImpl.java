package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.ProductConfigurationDao;
import com.senla.haltvinizki.entity.productCofniguration.ProductConfiguration;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConfigurationDaoImpl implements ProductConfigurationDao {
    List<ProductConfiguration> productConfigurationList;

    public ProductConfigurationDaoImpl() {
        this.productConfigurationList = new ArrayList<>();
        productConfigurationList.add(new ProductConfiguration(0,0,0,5000,100,12));
        productConfigurationList.add(new ProductConfiguration(0,0,1,50,10,10));
    }

    @Override
    public ProductConfiguration delete(ProductConfiguration productConfiguration) {
        productConfigurationList.remove(productConfiguration);
        return productConfiguration;
    }

    @Override
    public ProductConfiguration create(ProductConfiguration productConfiguration) {
        productConfigurationList.add(productConfiguration);
        return productConfiguration;
    }

    @Override
    public ProductConfiguration update(ProductConfiguration productConfiguration) {
        for (ProductConfiguration soughtProductConfiguration:read()){
            if (soughtProductConfiguration.getId()==productConfiguration.getId()){
                soughtProductConfiguration=productConfiguration;
            }
        }
        return productConfiguration;
    }

    @Override
    public List<ProductConfiguration> read() {
        return productConfigurationList;
    }
}
