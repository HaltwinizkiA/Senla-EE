package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.impl.ProductConfigurationDaoImpl;
import com.senla.haltvinizki.entity.productCofniguration.ProductConfiguration;
import com.senla.haltvinizki.services.ProductConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
@RequiredArgsConstructor
public class ProductConfigurationServiceImpl implements ProductConfigurationService {
    @Autowired
    private final ProductConfigurationDaoImpl productConfigurationDao;


    @Override
    public ProductConfiguration delete(ProductConfiguration productConfiguration) {
        return productConfigurationDao.delete(productConfiguration);
    }

    @Override
    public ProductConfiguration create(ProductConfiguration productConfiguration) {
        return productConfigurationDao.create(productConfiguration);
    }

    @Override
    public ProductConfiguration update(ProductConfiguration productConfiguration) {
        return productConfigurationDao.update(productConfiguration);
    }

    @Override
    public ProductConfiguration getById(int id) {
        return productConfigurationDao.getById(id);
    }
}
