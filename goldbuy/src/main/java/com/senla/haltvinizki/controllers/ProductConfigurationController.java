package com.senla.haltvinizki.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.productConfiguration.ProductConfigurationInfoDto;
import com.senla.haltvinizki.services.ProductConfigurationService;

public class ProductConfigurationController {
    private final ProductConfigurationService productConfigurationService;
    private final JsonMapper gsonMapper;

    public ProductConfigurationController(ProductConfigurationService productConfigurationService, JsonMapper gsonMapper) {
        this.productConfigurationService = productConfigurationService;
        this.gsonMapper = gsonMapper;
    }

    public String createProductConfiguration(String jsonProductConfiguration) {
        try {
            ProductConfigurationInfoDto productConfigurationDto = productConfigurationService.create((ProductConfigurationInfoDto) gsonMapper.createObj(jsonProductConfiguration, ProductConfigurationInfoDto.class));
            return gsonMapper.createJson(productConfigurationDto);

        } catch (JsonProcessingException e) {
            return "productConfiguration not create";
        }

    }

    public String getById(int id) {
        return gsonMapper.createJson(productConfigurationService.getById(id));
    }

    public String updateProductConfiguration(String jsonProductConfiguration) {
        try {
            ProductConfigurationInfoDto productConfigurationDto = productConfigurationService.update((ProductConfigurationInfoDto) gsonMapper.createObj(jsonProductConfiguration, ProductConfigurationInfoDto.class));
            return gsonMapper.createJson(productConfigurationDto);

        } catch (JsonProcessingException e) {
            return "productConfiguration not update";
        }
    }

    public String deleteProductConfiguration(String jsonProductConfiguration) {
        try {
            ProductConfigurationInfoDto productConfigurationDto = productConfigurationService.delete((ProductConfigurationInfoDto) gsonMapper.createObj(jsonProductConfiguration, ProductConfigurationInfoDto.class));
            return gsonMapper.createJson(productConfigurationDto);

        } catch (JsonProcessingException e) {
            return "productConfiguration not delete";
        }
    }
}
