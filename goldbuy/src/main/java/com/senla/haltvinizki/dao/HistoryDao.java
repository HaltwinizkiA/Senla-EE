package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.History;


public interface HistoryDao extends GenericDao<History, Long> {
    History getHistoryWithProduct(Long id);

    History getHistoryWithCustomer(Long id);


}
