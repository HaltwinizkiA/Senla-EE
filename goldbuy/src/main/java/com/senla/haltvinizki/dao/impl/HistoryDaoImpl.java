package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.HistoryDao;
import com.senla.haltvinizki.entity.history.History;
import org.springframework.stereotype.Component;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Component
public class HistoryDaoImpl extends AbstractDao<History, Integer> implements HistoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public HistoryDaoImpl() {
        super(History.class);
    }

    @Override
    public History getHistoryWithProduct(int id) {

        EntityGraph userGraph=entityManager.getEntityGraph("history-product");
        Map hints=new HashMap();
        hints.put("javax.persistence.fetchgraph",userGraph);
        return entityManager.find(History.class,id,hints);
    }

    @Override
    public History getHistoryWithCustomer(int id) {
        return entityManager.createQuery("select history from History history left join fetch history.customer where history.id= :id",History.class)
                .setParameter("id",id).getSingleResult();

    }
}
