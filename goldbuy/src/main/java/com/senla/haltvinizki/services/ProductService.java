package com.senla.haltvinizki.services;

import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.dto.product.ProductWithCategoryDto;
import com.senla.haltvinizki.dto.product.ProductWithUserDto;

import java.util.List;

public interface ProductService {
    ProductInfoDto delete(ProductInfoDto productDto);

    ProductInfoDto create(ProductInfoDto productDto);

    ProductInfoDto update(ProductInfoDto productDto);

    ProductInfoDto getById(int id);

    ProductInfoDto getMostExpensiveProduct();

    ProductWithUserDto getProductWithUser(int id);

    ProductWithCategoryDto getProductWithCategory(int id);

    List<ProductInfoDto> getActiveProducts();

}
