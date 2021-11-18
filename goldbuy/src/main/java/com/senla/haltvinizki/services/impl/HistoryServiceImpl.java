package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.HistoryDao;
import com.senla.haltvinizki.entity.history.History;
import com.senla.haltvinizki.services.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private final HistoryDao historyDao;

    @Override
    public History delete(History history) {
        return historyDao.delete(history);
    }

    @Override
    public History create(History history) {
        return historyDao.create(history);
    }

    @Override
    public History update(History history) {
        return historyDao.update(history);
    }

    @Override
    public History getById(int id) {
        return historyDao.getById(id);
    }
}
