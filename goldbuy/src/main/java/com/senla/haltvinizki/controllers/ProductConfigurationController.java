package com.senla.haltvinizki.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.entity.productCofniguration.ProductConfiguration;
import com.senla.haltvinizki.services.ProductConfigurationService;
import com.senla.haltvinizki.util.Logger;

public class ProductConfigurationController {
    private final ProductConfigurationService productConfigurationService;
    private final JsonMapper gsonMapper;

    public ProductConfigurationController(ProductConfigurationService productConfigurationService, JsonMapper gsonMapper) {
        this.productConfigurationService = productConfigurationService;
        this.gsonMapper = gsonMapper;
    }

    public String createProductConfiguration(String jsonProductConfiguration) {
        try {
            ProductConfiguration productConfiguration = productConfigurationService.create((ProductConfiguration) gsonMapper.createObj(jsonProductConfiguration, ProductConfiguration.class));
            return gsonMapper.createJson(productConfiguration);

        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "productConfiguration not create";
        }

    }

    public String getById(int id) {
        return gsonMapper.createJson(productConfigurationService.getById(id));
    }

    public String updateProductConfiguration(String jsonProductConfiguration) {
        try {
            ProductConfiguration productConfiguration = productConfigurationService.update((ProductConfiguration) gsonMapper.createObj(jsonProductConfiguration, ProductConfiguration.class));
            return gsonMapper.createJson(productConfiguration);

        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "productConfiguration not update";
        }
    }

    public String deleteProductConfiguration(String jsonProductConfiguration) {
        try {
            ProductConfiguration productConfiguration = productConfigurationService.delete((ProductConfiguration) gsonMapper.createObj(jsonProductConfiguration, ProductConfiguration.class));
            return gsonMapper.createJson(productConfiguration);

        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "productConfiguration not delete";
        }
    }
}
