package com.senla.haltvinizki.services;

import com.senla.haltvinizki.dto.history.HistoryInfoDto;
import com.senla.haltvinizki.dto.history.HistoryWithCustomerDto;
import com.senla.haltvinizki.dto.history.HistoryWithProductDto;

public interface HistoryService {
    HistoryInfoDto delete(HistoryInfoDto historyDto);

    HistoryInfoDto create(HistoryInfoDto historyDto);

    HistoryInfoDto update(HistoryInfoDto historyDto);

    HistoryInfoDto getById(int id);

    HistoryWithProductDto getHistoryWithProduct(int id);

    HistoryWithCustomerDto getHistoryWithCustomer(int id);
}
