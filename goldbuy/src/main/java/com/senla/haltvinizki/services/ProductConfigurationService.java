package com.senla.haltvinizki.services;

import com.senla.haltvinizki.dto.productConfiguration.ProductConfigurationInfoDto;
import com.senla.haltvinizki.dto.productConfiguration.ProductConfigurationWithProductDto;

public interface ProductConfigurationService {
    ProductConfigurationInfoDto delete(ProductConfigurationInfoDto productConfigurationDto);

    ProductConfigurationInfoDto create(ProductConfigurationInfoDto productConfigurationDto);

    ProductConfigurationInfoDto update(ProductConfigurationInfoDto productConfigurationDto);

    ProductConfigurationInfoDto getById(int id);

    ProductConfigurationWithProductDto getProductConfigWithProduct(int id);
}
