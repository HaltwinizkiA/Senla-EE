package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.impl.ProductConfigurationDaoImpl;
import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationInfoDto;
import com.senla.haltvinizki.dto.product_configuration.ProductConfigurationWithProductDto;
import com.senla.haltvinizki.entity.ProductConfiguration;
import com.senla.haltvinizki.services.ProductConfigurationService;
import com.senla.haltvinizki.services.converter.ProductConfigurationConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
@RequiredArgsConstructor
public class ProductConfigurationServiceImpl implements ProductConfigurationService {
    private final ProductConfigurationDaoImpl productConfigurationDao;
   private final ProductConfigurationConverter productConfigurationConverter;

    @Override
    public ProductConfigurationInfoDto delete(Long id) {
        return productConfigurationConverter.convert(productConfigurationDao.delete(id));
    }

    @Override
    public ProductConfigurationInfoDto create(ProductConfigurationInfoDto productConfigurationDto) {
       ProductConfiguration productConfiguration =productConfigurationConverter.convert(productConfigurationDto);
       return productConfigurationConverter.convert(productConfigurationDao.create(productConfiguration));
    }

    @Override
    public ProductConfigurationInfoDto update(ProductConfigurationInfoDto productConfigurationDto) {
        ProductConfiguration productConfiguration =productConfigurationConverter.convert(productConfigurationDto);
        return productConfigurationConverter.convert(productConfigurationDao.update(productConfiguration));
    }

    @Override
    public ProductConfigurationInfoDto getById(Long id) {
       return productConfigurationConverter.convert(productConfigurationDao.getById(id));
    }

    @Override
    public ProductConfigurationWithProductDto getProductConfigWithProduct(Long id) {
        ProductConfigurationWithProductDto productConfigurationWithProductDto=productConfigurationConverter.convertWithProduct(productConfigurationDao.getProductConfigWithProduct(id));
        productConfigurationWithProductDto.setProduct(productConfigurationConverter.convert(productConfigurationDao.getById(id)));
        return productConfigurationWithProductDto;
    }
}
