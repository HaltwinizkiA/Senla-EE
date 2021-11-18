package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.HistoryDao;
import com.senla.haltvinizki.entity.history.History;
import org.springframework.stereotype.Component;

@Component
public class HistoryDaoImpl extends AbstractDao<History, Integer> implements HistoryDao {
    public HistoryDaoImpl() {
        super(History.class);
    }

}
