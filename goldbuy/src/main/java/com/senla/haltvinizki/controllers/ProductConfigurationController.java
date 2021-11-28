package com.senla.haltvinizki.controllers;

import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationInfoDto;
import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationWithProductDto;
import com.senla.haltvinizki.services.ProductConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/product-configurations")
@RequiredArgsConstructor
public class ProductConfigurationController {
    private final ProductConfigurationService productConfigurationService;


    @PostMapping
    public ProductConfigurationInfoDto createProductConfiguration(@RequestBody ProductConfigurationInfoDto productConfigurationInfoDto) {
        return productConfigurationService.create(productConfigurationInfoDto);

    }

    @GetMapping(value = "/{id}")
    public ProductConfigurationInfoDto getById(@PathVariable Long id) {
        return productConfigurationService.getById(id);
    }

    @PutMapping
    public ProductConfigurationInfoDto updateProductConfiguration(@RequestBody ProductConfigurationInfoDto productConfigurationInfoDto) {
        return productConfigurationService.update(productConfigurationInfoDto);
    }

    @DeleteMapping(value = "/{id}")
    public ProductConfigurationInfoDto deleteProductConfiguration(@PathVariable Long id) {
        return productConfigurationService.delete(id);
    }
//    @GetMapping(value ="/{id}")
//    public ProductConfigurationWithProductDto getProductConfigurationWithProduct(@PathVariable Long id){
//        return productConfigurationService.getProductConfigWithProduct(id);
//    }
}
