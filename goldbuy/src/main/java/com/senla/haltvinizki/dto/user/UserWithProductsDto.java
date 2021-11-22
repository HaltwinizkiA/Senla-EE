package com.senla.haltvinizki.dto.user;

import com.senla.haltvinizki.dto.product.ProductInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class UserWithProductsDto {
    private UserInfoDto user;
    private List<ProductInfoDto> products;

    public UserInfoDto getUser() {
        return user;
    }

    public void setUser(UserInfoDto user) {
        this.user = user;
    }

    public List<ProductInfoDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInfoDto> products) {
        this.products = products;
    }

}
