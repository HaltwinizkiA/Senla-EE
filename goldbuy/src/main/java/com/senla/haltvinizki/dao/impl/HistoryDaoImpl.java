package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.HistoryDao;
import com.senla.haltvinizki.configuration.GraphConfiguration;
import com.senla.haltvinizki.entity.History;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.Map;

@Repository
public class HistoryDaoImpl extends AbstractDao<History, Long> implements HistoryDao {

    public HistoryDaoImpl() {
        super(History.class);
    }

    @Override
    public History getHistoryWithProduct(Long id) {
        EntityGraph userGraph=entityManager.getEntityGraph(GraphConfiguration.HISTORY_PRODUCT);
        Map hints=new HashMap();
        hints.put(GRAPH_PERSISTENCE,userGraph);
        return entityManager.find(History.class,id,hints);
    }

    @Override
    public History getHistoryWithCustomer(Long id) {
        EntityGraph userGraph=entityManager.getEntityGraph(GraphConfiguration.HISTORY_PRODUCT);
        Map hints=new HashMap();
        hints.put(GRAPH_PERSISTENCE,userGraph);
        return entityManager.find(History.class,id,hints);

    }
}
