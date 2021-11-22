package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.HistoryDao;
import com.senla.haltvinizki.configuration.GraphConfiguration;
import com.senla.haltvinizki.entity.History;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.Map;

@Repository
public class HistoryDaoImpl extends AbstractDao<History, Integer> implements HistoryDao {

    public HistoryDaoImpl() {
        super(History.class);
    }

    @Override
    public History getHistoryWithProduct(int id) {

        EntityGraph userGraph=entityManager.getEntityGraph(GraphConfiguration.HISTORY_PRODUCT);
        Map hints=new HashMap();
        hints.put(GRAPH_PERSISTENCE,userGraph);
        return entityManager.find(History.class,id,hints);
    }

    @Override
    public History getHistoryWithCustomer(int id) {
        return entityManager.createQuery("select history from History history left join fetch history.customer where history.id= :id",History.class)
                .setParameter("id",id).getSingleResult();

    }
}
