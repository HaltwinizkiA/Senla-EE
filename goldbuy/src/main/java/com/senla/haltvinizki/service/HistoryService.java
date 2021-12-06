package com.senla.haltvinizki.service;

import com.senla.haltvinizki.dto.history.HistoryInfoDto;
import com.senla.haltvinizki.dto.history.HistoryWithCustomerDto;
import com.senla.haltvinizki.dto.history.HistoryWithProductDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface HistoryService {
    HistoryInfoDto delete(Long id);

    HistoryInfoDto create(HistoryInfoDto historyDto);

    HistoryInfoDto update(HistoryInfoDto historyDto);

    HistoryInfoDto getById(Long id);

    HistoryWithProductDto getHistoryWithProduct(Long id);

    HistoryWithCustomerDto getHistoryWithCustomer(Long id);

    List<HistoryInfoDto> getByUserId(long id);
}
