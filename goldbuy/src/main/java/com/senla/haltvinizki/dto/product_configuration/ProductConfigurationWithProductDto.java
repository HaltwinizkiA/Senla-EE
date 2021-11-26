package com.senla.haltvinizki.dto.product_configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductConfigurationWithProductDto {

    private ProductConfigurationInfoDto product;
    private ProductConfigurationInfoDto productConfiguration;

    public ProductConfigurationInfoDto getProduct() {
        return product;
    }

    public void setProduct(ProductConfigurationInfoDto product) {
        this.product = product;
    }

    public ProductConfigurationInfoDto getProductConfiguration() {
        return productConfiguration;
    }

    public void setProductConfiguration(ProductConfigurationInfoDto productConfiguration) {
        this.productConfiguration = productConfiguration;
    }
}
