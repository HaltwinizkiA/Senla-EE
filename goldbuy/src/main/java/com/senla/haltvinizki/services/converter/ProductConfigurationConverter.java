package com.senla.haltvinizki.services.converter;

import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationInfoDto;
import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationWithProductDto;
import com.senla.haltvinizki.entity.ProductConfiguration;
import org.modelmapper.ModelMapper;

public class ProductConfigurationConverter {
    ModelMapper mapper = new ModelMapper();

    public ProductConfiguration convert(ProductConfigurationInfoDto productConfigurationInfoDto) {
        return mapper.map(productConfigurationInfoDto, ProductConfiguration.class);
    }

    public ProductConfigurationInfoDto convert(ProductConfiguration productConfiguration) {
        return mapper.map(productConfiguration, ProductConfigurationInfoDto.class);
    }

    public ProductConfiguration convert(ProductConfigurationWithProductDto productConfigurationWithProductDto) {
        return mapper.map(productConfigurationWithProductDto, ProductConfiguration.class);
    }

    public ProductConfigurationWithProductDto convertWithProduct(ProductConfiguration productConfiguration) {
        return mapper.map(productConfiguration, ProductConfigurationWithProductDto.class);
    }
}
