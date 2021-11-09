package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.HistoryDao;
import com.senla.haltvinizki.entity.history.History;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class HistoryDaoImpl implements HistoryDao {
    List<History> historyList;

    public HistoryDaoImpl() {
        this.historyList = new ArrayList<>();
        historyList.add(new History(6000, new Date(), 0, 1, 0));
        historyList.add(new History(60, new Date(), 1, 1, 1));
    }

    @Override
    public History delete(History history) {
        historyList.removeIf(soughtHistory -> soughtHistory.getId() == history.getId());
        return history;
    }

    @Override
    public History create(History history) {
        historyList.add(history);
        return history;
    }

    @Override
    public History update(History history) {
        for (History soughtHistory : historyList) {
            if (soughtHistory.getId() == history.getId()) {
                historyList.remove(soughtHistory);
                historyList.add(history);
            }
        }
        return history;
    }

    @Override
    public List<History> read() {
        return historyList;
    }
}
