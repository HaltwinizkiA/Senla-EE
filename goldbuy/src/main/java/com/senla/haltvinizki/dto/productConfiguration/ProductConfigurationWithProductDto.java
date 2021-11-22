package com.senla.haltvinizki.dto.productConfiguration;

import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.dto.product.ProductWithUserDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ProductConfigurationWithProductDto {

    private ProductInfoDto product;
    private ProductConfigurationInfoDto productConfiguration;

    public ProductInfoDto getProduct() {
        return product;
    }

    public void setProduct(ProductInfoDto product) {
        this.product = product;
    }

    public ProductConfigurationInfoDto getProductConfiguration() {
        return productConfiguration;
    }

    public void setProductConfiguration(ProductConfigurationInfoDto productConfiguration) {
        this.productConfiguration = productConfiguration;
    }
}
