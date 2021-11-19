package com.senla.haltvinizki.services;

import com.senla.haltvinizki.entity.history.History;

import java.util.List;

public interface HistoryService {
    History delete(History history);

    History create(History history);

    History update(History history);

    History getById(int id);

    History getHistoryWithProduct(int id);

    History getHistoryWithCustomer(int id);
}
