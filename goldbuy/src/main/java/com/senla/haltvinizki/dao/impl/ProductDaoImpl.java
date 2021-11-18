package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.ProductDao;
import com.senla.haltvinizki.entity.product.Product;
import com.senla.haltvinizki.entity.user.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ProductDaoImpl extends AbstractDao<Product, Integer> implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductDaoImpl() {
        super(Product.class);
    }

    @Override
    public String getMailSellerProduct(int id) {
       return   entityManager.
                createQuery("SELECT u.mail from Product p WHERE p.id=:id ", User.class)
                .setParameter("id", id).getResultList().toString();

    }
}
