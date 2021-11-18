package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.ProductConfigurationDao;
import com.senla.haltvinizki.entity.productCofniguration.ProductConfiguration;
import org.springframework.stereotype.Component;

@Component
public class ProductConfigurationDaoImpl extends AbstractDao<ProductConfiguration, Integer> implements ProductConfigurationDao {
    public ProductConfigurationDaoImpl() {
        super(ProductConfiguration.class);
    }

}
