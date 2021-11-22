package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.History;


public interface HistoryDao extends GenericDao<History, Integer> {
    History getHistoryWithProduct(int id);

    History getHistoryWithCustomer(int id);


}
