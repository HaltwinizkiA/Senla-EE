package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.entity.category.Category;
import org.springframework.stereotype.Component;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;


@Component
public class CategoryDaoImpl extends AbstractDao<Category, Integer> implements CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public CategoryDaoImpl() {
        super(Category.class);
    }

    @Override
    public Category getCategoryWithProduct(int id) {
        EntityGraph userGraph = entityManager.getEntityGraph("category-product");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", userGraph);
        return entityManager.find(Category.class, id, hints);
    }


}

