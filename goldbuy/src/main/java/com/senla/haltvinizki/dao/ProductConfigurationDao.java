package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.ProductConfiguration;

public interface ProductConfigurationDao extends GenericDao<ProductConfiguration, Integer> {
    ProductConfiguration getProductConfigWithProduct(int id);

}
