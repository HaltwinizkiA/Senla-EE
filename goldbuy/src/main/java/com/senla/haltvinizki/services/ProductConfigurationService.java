package com.senla.haltvinizki.services;

import com.senla.haltvinizki.entity.productCofniguration.ProductConfiguration;

import java.util.List;

public interface ProductConfigurationService {
    ProductConfiguration delete(ProductConfiguration productConfiguration);

    ProductConfiguration create(ProductConfiguration productConfiguration);

    ProductConfiguration update(ProductConfiguration productConfiguration);

    ProductConfiguration getById(int id);
}
