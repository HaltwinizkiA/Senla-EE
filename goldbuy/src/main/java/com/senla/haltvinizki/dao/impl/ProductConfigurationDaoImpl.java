package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.ProductConfigurationDao;
import com.senla.haltvinizki.dao.configuration.GraphConfiguration;
import com.senla.haltvinizki.entity.productCofniguration.ProductConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductConfigurationDaoImpl extends AbstractDao<ProductConfiguration, Integer> implements ProductConfigurationDao {

    public ProductConfigurationDaoImpl() {
        super(ProductConfiguration.class);
    }

    @Override
    public ProductConfiguration getProductConfigWithProduct(int id) {
        EntityGraph userGraph=entityManager.getEntityGraph(GraphConfiguration.PRODUCTCONFIG_PRODUCT);
        Map hints=new HashMap();
        hints.put(graphPersistence,userGraph);
        return entityManager.find(ProductConfiguration.class,id,hints);
    }
}
