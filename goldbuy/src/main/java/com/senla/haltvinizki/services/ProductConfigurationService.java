package com.senla.haltvinizki.services;

import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationInfoDto;
import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationWithProductDto;

public interface ProductConfigurationService {
    ProductConfigurationInfoDto delete(ProductConfigurationInfoDto productConfigurationDto);

    ProductConfigurationInfoDto create(ProductConfigurationInfoDto productConfigurationDto);

    ProductConfigurationInfoDto update(ProductConfigurationInfoDto productConfigurationDto);

    ProductConfigurationInfoDto getById(int id);

    ProductConfigurationWithProductDto getProductConfigWithProduct(int id);
}
