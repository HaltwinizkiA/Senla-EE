package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.productCofniguration.ProductConfiguration;

import java.util.List;

public interface ProductConfigurationDao {
    ProductConfiguration delete(ProductConfiguration productConfiguration);

    ProductConfiguration create(ProductConfiguration productConfiguration);

    ProductConfiguration update(ProductConfiguration productConfiguration);

    List<ProductConfiguration> read();
}
