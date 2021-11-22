package com.senla.haltvinizki.dto.category;


import com.senla.haltvinizki.dto.product.ProductInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryWithProductDto {

    private CategoryInfoDto category ;
    private List<ProductInfoDto> products;

    public List<ProductInfoDto> getProducts() {
        return products;
    }


    public CategoryInfoDto getCategoryInfoDto() {
        return category;
    }

    public void setCategoryInfoDto(CategoryInfoDto categoryInfoDto) {
        this.category = categoryInfoDto;
    }

    public void setProducts(List<ProductInfoDto> products) {
        this.products = products;
    }
}
