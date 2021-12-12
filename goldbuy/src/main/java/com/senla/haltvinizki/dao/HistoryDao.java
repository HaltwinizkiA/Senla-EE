package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.History;

import java.util.List;


public interface HistoryDao extends GenericDao<History, Long> {
    History getHistoryWithProduct(Long id);

    History getHistoryWithCustomer(Long id);

    List<History> getByUserId(Long id);

    History getByProductId(Long productId,Long userId);
}
