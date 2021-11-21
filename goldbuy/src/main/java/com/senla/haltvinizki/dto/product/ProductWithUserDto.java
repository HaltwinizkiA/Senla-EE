package com.senla.haltvinizki.dto.product;

import com.senla.haltvinizki.dto.user.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ProductWithUserDto {
    private ProductInfoDto product;
    private UserInfoDto user;


    public ProductInfoDto getProduct() {
        return product;
    }

    public void setProduct(ProductInfoDto product) {
        this.product = product;
    }

    public UserInfoDto getUser() {
        return user;
    }

    public void setUser(UserInfoDto user) {
        this.user = user;
    }
}