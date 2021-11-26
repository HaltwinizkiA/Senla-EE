package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.HistoryDao;
import com.senla.haltvinizki.dto.history.HistoryInfoDto;
import com.senla.haltvinizki.dto.history.HistoryWithCustomerDto;
import com.senla.haltvinizki.dto.history.HistoryWithProductDto;
import com.senla.haltvinizki.entity.History;
import com.senla.haltvinizki.services.HistoryService;
import com.senla.haltvinizki.services.converter.HistoryConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryDao historyDao;
    private final HistoryConverter historyConverter;

    @Override
    public HistoryInfoDto delete(Long id) {
        return historyConverter.convert(historyDao.delete(id));
    }


    @Override
    public HistoryInfoDto create(HistoryInfoDto historyDto) {
        History history = historyConverter.convert(historyDto);
        return historyConverter.convert(historyDao.create(history));
    }

    @Override
    public HistoryInfoDto update(HistoryInfoDto historyDto) {
        History history = historyConverter.convert(historyDto);
        return historyConverter.convert(historyDao.update(history));
    }

    @Override
    public HistoryInfoDto getById(Long id) {
        return historyConverter.convert(historyDao.getById(id));
    }

    @Override
    public HistoryWithProductDto getHistoryWithProduct(Long id) {
        HistoryWithProductDto historyWithProductDto = historyConverter.convertWithProduct(historyDao.getHistoryWithProduct(id));
        historyWithProductDto.setHistory(historyConverter.convert(historyDao.getById(id)));
        return historyWithProductDto;
    }

    @Override
    public HistoryWithCustomerDto getHistoryWithCustomer(Long id) {
        HistoryWithCustomerDto historyWithCustomerDto = historyConverter.convertWithCustomer(historyDao.getHistoryWithCustomer(id));
        historyWithCustomerDto.setHistory(historyConverter.convert(historyDao.getById(id)));
        return historyWithCustomerDto;
    }
}
