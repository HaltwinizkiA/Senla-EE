package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.configuration.GraphConfiguration;
import com.senla.haltvinizki.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.Map;


@Repository
public class CategoryDaoImpl extends AbstractDao<Category, Long> implements CategoryDao {

    public CategoryDaoImpl() {
        super(Category.class);
    }

    @Override
    public Category getCategoryWithProduct(Long id) {
        EntityGraph userGraph = entityManager.getEntityGraph(GraphConfiguration.CATEGORY_PRODUCTS);
        Map hints = new HashMap();
        hints.put(GRAPH_PERSISTENCE, userGraph);
        return entityManager.find(Category.class, id, hints);
    }

    @Override
    public Category getByName(String name) {
        return null;
    }


}

