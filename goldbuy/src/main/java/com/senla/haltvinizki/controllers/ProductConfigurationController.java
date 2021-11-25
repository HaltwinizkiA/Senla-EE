package com.senla.haltvinizki.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationInfoDto;
import com.senla.haltvinizki.services.ProductConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/productConfigurations")
@RequiredArgsConstructor
public class ProductConfigurationController {
    private final ProductConfigurationService productConfigurationService;
    private final JsonMapper gsonMapper;


    @PostMapping
    public String createProductConfiguration(String jsonProductConfiguration) {
        try {
            ProductConfigurationInfoDto productConfigurationDto = productConfigurationService.create((ProductConfigurationInfoDto) gsonMapper.createObj(jsonProductConfiguration, ProductConfigurationInfoDto.class));
            return gsonMapper.createJson(productConfigurationDto);

        } catch (JsonProcessingException e) {
            return "productConfiguration not create";
        }

    }

    @GetMapping(value = "/{id}")
    public String getById(int id) {
        return gsonMapper.createJson(productConfigurationService.getById(id));
    }

    @PutMapping
    public String updateProductConfiguration(String jsonProductConfiguration) {
        try {
            ProductConfigurationInfoDto productConfigurationDto = productConfigurationService.update((ProductConfigurationInfoDto) gsonMapper.createObj(jsonProductConfiguration, ProductConfigurationInfoDto.class));
            return gsonMapper.createJson(productConfigurationDto);

        } catch (JsonProcessingException e) {
            return "productConfiguration not update";
        }
    }

    @DeleteMapping(value = "/{id}")
    public String deleteProductConfiguration(String jsonProductConfiguration) {
        try {
            ProductConfigurationInfoDto productConfigurationDto = productConfigurationService.delete((ProductConfigurationInfoDto) gsonMapper.createObj(jsonProductConfiguration, ProductConfigurationInfoDto.class));
            return gsonMapper.createJson(productConfigurationDto);

        } catch (JsonProcessingException e) {
            return "productConfiguration not delete";
        }
    }
}
