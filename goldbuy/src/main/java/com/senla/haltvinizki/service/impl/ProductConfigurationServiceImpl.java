package com.senla.haltvinizki.service.impl;

import com.senla.haltvinizki.dao.ProductConfigurationDao;
import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationInfoDto;
import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationWithProductDto;
import com.senla.haltvinizki.entity.ProductConfiguration;
import com.senla.haltvinizki.service.ProductConfigurationService;
import com.senla.haltvinizki.service.converter.ProductConfigurationConverter;
import com.senla.haltvinizki.service.exception.ProductConfigurationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Optional.ofNullable;


@Component
@Transactional
@RequiredArgsConstructor
public class ProductConfigurationServiceImpl implements ProductConfigurationService {

    private final ProductConfigurationDao productConfigurationDao;
    private final ProductConfigurationConverter productConfigurationConverter;

    @Override
    public ProductConfigurationInfoDto delete(Long id) {
        return productConfigurationConverter.convert(productConfigurationDao.delete(id));
    }

    @Override
    public ProductConfigurationInfoDto create(ProductConfigurationInfoDto productConfigurationDto) {
        ProductConfiguration productConfiguration = productConfigurationConverter.convert(productConfigurationDto);
        return productConfigurationConverter.convert(productConfigurationDao.create(productConfiguration));
    }

    @Override
    public ProductConfigurationInfoDto update(ProductConfigurationInfoDto productConfigurationDto) {
        ProductConfiguration productConfiguration = productConfigurationConverter.convert(productConfigurationDto);
        return productConfigurationConverter.convert(productConfigurationDao.update(productConfiguration));
    }

    @Override
    public ProductConfigurationInfoDto getById(Long id) {
        final ProductConfiguration productConfiguration = ofNullable(productConfigurationDao.getById(id))
                .orElseThrow(() -> new ProductConfigurationNotFoundException(id));
        return productConfigurationConverter.convert(productConfiguration);
    }

    @Override
    public ProductConfigurationWithProductDto getProductConfigWithProduct(Long id) {
        return productConfigurationConverter.convertWithProduct(productConfigurationDao.getProductConfigWithProduct(id));
    }

    @Override
    public ProductConfigurationInfoDto getByProductId(Long id) {
        return productConfigurationConverter.convert(productConfigurationDao.getByProductId(id));
    }

    @Override
    public ProductConfigurationWithProductDto getProductConfigWithProductChekUserId(Long userId, Long productId) {
        return productConfigurationConverter
                .convertWithProduct(productConfigurationDao
                        .getProductConfigWithProductChekUserId(userId,productId));
    }

    @Override
    public ProductConfigurationInfoDto update(Long userId, ProductConfigurationInfoDto productConfigurationDto) {
        ProductConfiguration productConfiguration=productConfigurationDao.getProductConfigWithProduct(productConfigurationDto.getId());
        if (productConfiguration.getProduct().getUser().getId()==userId){
            return productConfigurationConverter.convert(productConfigurationDao.update(productConfiguration));
        }
        throw new ProductConfigurationNotFoundException(productConfigurationDto.getId());
    }
}
