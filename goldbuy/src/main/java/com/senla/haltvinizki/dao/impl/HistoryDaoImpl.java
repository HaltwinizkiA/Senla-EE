package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.HistoryDao;
import com.senla.haltvinizki.configuration.GraphConfiguration;
import com.senla.haltvinizki.entity.Credentials;
import com.senla.haltvinizki.entity.History;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public List<History> getByUserId(Long id) {
        return entityManager.createQuery
                        ("select history from History history inner join fetch history.owner user where user.id= :id", History.class)
                .setParameter("id", id).getResultList();
    }

    @Override
    public History getByProductId(Long productId,Long userId) {
//        return entityManager.createQuery("select h from History h left join fetch h.product p left join user u where p.id= :productId and u.ud= :userId",History.class)
//                .setParameter("productId",productId).setParameter("userId",userId).getSingleResult();
        History history=entityManager.createQuery("select history from History history inner join fetch history.owner user inner join fetch history.product product where user.id=1 and product.id=1",
                History.class).getSingleResult();
       return entityManager.createQuery("select history from History history inner join fetch history.owner user inner join fetch history.product product where user.id= :userId and product.id= :productId",
                History.class).setParameter("userId",userId).setParameter("productId",productId).getSingleResult();
    }
}//todo
