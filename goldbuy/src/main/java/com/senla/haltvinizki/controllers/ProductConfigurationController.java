package com.senla.haltvinizki.controllers;

import com.senla.haltvinizki.controllers.mapper.GsonMapper;
import com.senla.haltvinizki.entity.productCofniguration.ProductConfiguration;
import com.senla.haltvinizki.services.ProductConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductConfigurationController {
    @Autowired
    ProductConfigurationService productConfigurationService;
    @Autowired
    GsonMapper gsonMapper;

    public ProductConfigurationController(ProductConfigurationService productConfigurationService, GsonMapper gsonMapper) {
        this.productConfigurationService = productConfigurationService;
        this.gsonMapper = gsonMapper;
    }

    public String createProductConfiguration(String jsonProductConfiguration) {
        ProductConfiguration productConfiguration = productConfigurationService.create((ProductConfiguration) gsonMapper.createObj(jsonProductConfiguration, ProductConfiguration.class));
        return gsonMapper.createJson(productConfiguration);
    }

    public String readProductConfiguration() {
        return gsonMapper.createJson(productConfigurationService.read());
    }

    public String updateProductConfiguration(String jsonProductConfiguration) {
        ProductConfiguration productConfiguration = productConfigurationService.update((ProductConfiguration) gsonMapper.createObj(jsonProductConfiguration, ProductConfiguration.class));
        return gsonMapper.createJson(productConfiguration);
    }

    public String deleteProductConfiguration(String jsonProductConfiguration) {
        ProductConfiguration productConfiguration = productConfigurationService.delete((ProductConfiguration) gsonMapper.createObj(jsonProductConfiguration, ProductConfiguration.class));
        return gsonMapper.createJson(productConfiguration);
    }
}
