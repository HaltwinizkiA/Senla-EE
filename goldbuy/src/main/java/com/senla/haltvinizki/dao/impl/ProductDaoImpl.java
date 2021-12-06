package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.configuration.GraphConfiguration;
import com.senla.haltvinizki.dao.ProductDao;
import com.senla.haltvinizki.entity.Product;
import com.senla.haltvinizki.entity.Product_;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl extends AbstractDao<Product, Long> implements ProductDao {

    public ProductDaoImpl() {
        super(Product.class);
    }

    @Override
    public Product getMostExpensiveProduct() {
        return entityManager.
                createQuery("SELECT p from Product p where price=(select max(pr.price) from Product pr)",
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
    public Product getProductWithUser(Long id) {
        EntityGraph userGraph = entityManager.getEntityGraph(GraphConfiguration.PRODUCT_USER);
        Map hints = new HashMap();
        hints.put(GRAPH_PERSISTENCE, userGraph);
        return entityManager.find(Product.class, id, hints);
    }

    @Override
    public Product getProductWithCategory(Long id) {
        EntityGraph userGraph = entityManager.getEntityGraph(GraphConfiguration.PRODUCT_CATEGORY);
        Map hints = new HashMap();
        hints.put(GRAPH_PERSISTENCE, userGraph);
        return entityManager.find(Product.class, id, hints);
    }

    @Override
    public List<Product> getByUserId(long id) {
        return entityManager.createQuery
                        ("select product from Product product left join fetch product.user user where user.id= :id", Product.class)
                .setParameter("id", id).getResultList();
    }
}
