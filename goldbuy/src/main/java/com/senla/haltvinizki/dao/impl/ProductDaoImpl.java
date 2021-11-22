package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.ProductDao;
import com.senla.haltvinizki.dao.configuration.GraphConfiguration;
import com.senla.haltvinizki.entity.product.Product;
import com.senla.haltvinizki.entity.product.Product_;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl extends AbstractDao<Product, Integer> implements ProductDao {

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
    public List<Product> getActiveProducts() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        return entityManager.createQuery(query.select(root).where(criteriaBuilder.equal(root.get(Product_.status), "active"))).getResultList();
    }

    @Override
    public Product getProductWithUser(int id) {
        EntityGraph userGraph = entityManager.getEntityGraph(GraphConfiguration.PRODUCT_USER);
        Map hints = new HashMap();
        hints.put(graphPersistence, userGraph);
        return entityManager.find(Product.class, id, hints);
    }

    @Override
    public Product getProductWithCategory(int id) {
        EntityGraph userGraph = entityManager.getEntityGraph(GraphConfiguration.PRODUCT_CATEGORY);
        Map hints = new HashMap();
        hints.put(graphPersistence, userGraph);
        return entityManager.find(Product.class, id, hints);
    }
}
