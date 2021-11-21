package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.impl.ProductConfigurationDaoImpl;
import com.senla.haltvinizki.dto.productConfiguration.ProductConfigurationInfoDto;
import com.senla.haltvinizki.dto.productConfiguration.ProductConfigurationWithProductDto;
import com.senla.haltvinizki.entity.productCofniguration.ProductConfiguration;
import com.senla.haltvinizki.services.ProductConfigurationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
@RequiredArgsConstructor
public class ProductConfigurationServiceImpl implements ProductConfigurationService {
    @Autowired
    private final ProductConfigurationDaoImpl productConfigurationDao;
    @Autowired
    private ModelMapper mapper;

    @Override
    public ProductConfigurationInfoDto delete(ProductConfigurationInfoDto productConfigurationDto) {
        ProductConfiguration history = mapper.map(productConfigurationDto, ProductConfiguration.class);
        return mapper.map(productConfigurationDao.delete(history), ProductConfigurationInfoDto.class);
    }

    @Override
    public ProductConfigurationInfoDto create(ProductConfigurationInfoDto productConfigurationDto) {
        ProductConfiguration history = mapper.map(productConfigurationDto, ProductConfiguration.class);
        return mapper.map(productConfigurationDao.create(history), ProductConfigurationInfoDto.class);
    }

    @Override
    public ProductConfigurationInfoDto update(ProductConfigurationInfoDto productConfigurationDto) {
        ProductConfiguration history = mapper.map(productConfigurationDto, ProductConfiguration.class);
        return mapper.map(productConfigurationDao.update(history), ProductConfigurationInfoDto.class);
    }

    @Override
    public ProductConfigurationInfoDto getById(int id) {
        ProductConfiguration productConfiguration = productConfigurationDao.getById(id);
        return mapper.map(productConfiguration, ProductConfigurationInfoDto.class);
    }

    @Override
    public ProductConfigurationWithProductDto getProductConfigWithProduct(int id) {
        ProductConfiguration productConfiguration = productConfigurationDao.getProductConfigWithProduct(id);
        return mapper.map(productConfiguration, ProductConfigurationWithProductDto.class);
    }
}
