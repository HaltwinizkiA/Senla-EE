package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.ProductDao;
import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.dto.product.ProductWithCategoryDto;
import com.senla.haltvinizki.dto.product.ProductWithUserDto;
import com.senla.haltvinizki.entity.Product;
import com.senla.haltvinizki.services.ProductService;
import com.senla.haltvinizki.services.converter.ProductConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final ProductConverter productConverter;

    @Override
    public ProductInfoDto delete(Long id) {
        return productConverter.convert(productDao.delete(id));
    }

    @Override
    public ProductInfoDto create(ProductInfoDto productDto) {
        Product product = productConverter.convert(productDto);
        return productConverter.convert(productDao.create(product));
    }

    @Override
    public ProductInfoDto update(ProductInfoDto productDto) {
        Product product = productConverter.convert(productDto);
        return productConverter.convert(productDao.update(product));
    }

    @Override
    public ProductInfoDto getById(Long id) {
        return productConverter.convert(productDao.getById(id));

    }

    @Override
    public ProductInfoDto getMostExpensiveProduct() {
        return productConverter.convert(productDao.getMostExpensiveProduct());
    }

    @Override
    public ProductWithUserDto getProductWithUser(Long id) {
        return productConverter.convertWithUser(productDao.getProductWithUser(id));
    }

    @Override
    public ProductWithCategoryDto getProductWithCategory(Long id) {
        return productConverter.convertWithCategory(productDao.getProductWithCategory(id));

    }

    @Override
    public List<ProductInfoDto> getActiveProducts() {
        return productConverter.convert(productDao.getActiveProducts());
    }
}
