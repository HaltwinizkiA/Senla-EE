package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.dao.configuration.GraphConfiguration;
import com.senla.haltvinizki.entity.category.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.Map;


@Repository
public class CategoryDaoImpl extends AbstractDao<Category, Integer> implements CategoryDao {

    public CategoryDaoImpl() {
        super(Category.class);
    }

    @Override
    public Category getCategoryWithProduct(int id) {
        EntityGraph userGraph = entityManager.getEntityGraph(GraphConfiguration.CATEGORY_PRODUCTS);
        Map hints = new HashMap();
        hints.put(graphPersistence, userGraph);
        return entityManager.find(Category.class, id, hints);
    }


}

