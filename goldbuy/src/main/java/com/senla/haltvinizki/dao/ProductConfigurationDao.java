package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.ProductConfiguration;

public interface ProductConfigurationDao extends GenericDao<ProductConfiguration, Long> {
    ProductConfiguration getProductConfigWithProduct(Long id);

    ProductConfiguration getByProductId(Long id);
}
