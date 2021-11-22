package com.senla.haltvinizki.services.impl;


import com.senla.haltvinizki.dao.ProductDao;
import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.dto.product.ProductWithCategoryDto;
import com.senla.haltvinizki.dto.product.ProductWithUserDto;
import com.senla.haltvinizki.entity.Product;
import com.senla.haltvinizki.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    @Autowired
    private ModelMapper mapper;

    @Override
    public ProductInfoDto delete(ProductInfoDto productDto) {
        return mapper.map(productDao.delete(productDto.getId()), ProductInfoDto.class);
    }

    @Override
    public ProductInfoDto create(ProductInfoDto productDto) {
        Product product = mapper.map(productDto, Product.class);
        return mapper.map(productDao.create(product), ProductInfoDto.class);
    }

    @Override
    public ProductInfoDto update(ProductInfoDto productDto) {
        Product product = mapper.map(productDto, Product.class);
        return mapper.map(productDao.update(product), ProductInfoDto.class);
    }

    @Override
    public ProductInfoDto getById(int id) {
        Product product = productDao.getById(id);
        return mapper.map(product, ProductInfoDto.class);

    }

    @Override
    public ProductInfoDto getMostExpensiveProduct() {
        Product product = productDao.getMostExpensiveProduct();
        return mapper.map(product, ProductInfoDto.class);
    }

    @Override
    public ProductWithUserDto getProductWithUser(int id) {
        Product product = productDao.getProductWithUser(id);
        return mapper.map(product, ProductWithUserDto.class);
    }

    @Override
    public ProductWithCategoryDto getProductWithCategory(int id) {
        Product product = productDao.getProductWithCategory(id);
        return mapper.map(product, ProductWithCategoryDto.class);
    }

    @Override
    public List<ProductInfoDto> getActiveProducts() {
        List<Product> products = productDao.getActiveProducts();
        return products.stream().
                map(product -> mapper.map(product, ProductInfoDto.class))
                .collect(Collectors.toList());
    }
}
