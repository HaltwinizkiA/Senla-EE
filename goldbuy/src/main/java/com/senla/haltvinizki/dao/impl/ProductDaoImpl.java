package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.ProductDao;
import com.senla.haltvinizki.entity.product.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductDaoImpl extends AbstractDao<Product, Integer> implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductDaoImpl() {
        super(Product.class);
    }

    @Override
    public Product getMostExpensiveProduct() {
        return entityManager.
                createQuery("SELECT p from Product p where p.price=(select max(pr.price) from Product pr)",
                        Product.class).getSingleResult();
    }

    @Override
    public Product getProductWithUser(int id) {
        EntityGraph userGraph = entityManager.getEntityGraph("with-user");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", userGraph);
        return entityManager.find(Product.class, id, hints);
    }

    @Override
    public Product getProductWithCategory(int id) {
        EntityGraph userGraph = entityManager.getEntityGraph("with-category");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", userGraph);
        return entityManager.find(Product.class, id, hints);
    }
}
