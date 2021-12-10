package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.configuration.GraphConfiguration;
import com.senla.haltvinizki.dao.ProductConfigurationDao;
import com.senla.haltvinizki.entity.ProductConfiguration;
import com.senla.haltvinizki.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductConfigurationDaoImpl extends AbstractDao<ProductConfiguration, Long> implements ProductConfigurationDao {

    public ProductConfigurationDaoImpl() {
        super(ProductConfiguration.class);
    }

    @Override
    public ProductConfiguration getProductConfigWithProduct(Long id) {
        EntityGraph userGraph = entityManager.getEntityGraph(GraphConfiguration.PRODUCTCONFIG_PRODUCT);
        Map hints = new HashMap();
        hints.put(GRAPH_PERSISTENCE, userGraph);
        return entityManager.find(ProductConfiguration.class, id, hints);
    }

    @Override
    public ProductConfiguration getByProductId(Long id) {
        return entityManager.createQuery
                        ("select config from ProductConfiguration config inner join fetch config.product product where product.id= :id", ProductConfiguration.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public ProductConfiguration getProductConfigWithProductChekUserId(Long userId, Long productId) {
        return entityManager.createQuery
                ("select config from ProductConfiguration config inner join fetch config.product product where product.id= :productId" +
                        " and (select u.id from Product p join fetch  p.user u where p.id= :productId)= :userId", ProductConfiguration.class)//todo
                .setParameter("userId", userId).setParameter("productId",productId).getSingleResult();//todo
    }
}
