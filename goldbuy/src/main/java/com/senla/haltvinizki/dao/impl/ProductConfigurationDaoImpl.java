package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.ProductConfigurationDao;
import com.senla.haltvinizki.entity.productCofniguration.ProductConfiguration;
import org.springframework.stereotype.Component;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductConfigurationDaoImpl extends AbstractDao<ProductConfiguration, Integer> implements ProductConfigurationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductConfigurationDaoImpl() {
        super(ProductConfiguration.class);
    }

    @Override
    public ProductConfiguration getProductConfigWithProduct(int id) {
        EntityGraph userGraph=entityManager.getEntityGraph("prodconfig-product");
        Map hints=new HashMap();
        hints.put("javax.persistence.fetchgraph",userGraph);
        return entityManager.find(ProductConfiguration.class,id,hints);
    }
}
