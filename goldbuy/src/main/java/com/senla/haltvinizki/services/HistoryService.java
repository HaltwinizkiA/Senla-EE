package com.senla.haltvinizki.services;

import com.senla.haltvinizki.dto.history.HistoryInfoDto;
import com.senla.haltvinizki.dto.history.HistoryWithCustomerDto;
import com.senla.haltvinizki.dto.history.HistoryWithProductDto;

public interface HistoryService {
    HistoryInfoDto delete(Long id);

    HistoryInfoDto create(HistoryInfoDto historyDto);

    HistoryInfoDto update(HistoryInfoDto historyDto);

    HistoryInfoDto getById(Long id);

    HistoryWithProductDto getHistoryWithProduct(Long id);

    HistoryWithCustomerDto getHistoryWithCustomer(Long id);
}
