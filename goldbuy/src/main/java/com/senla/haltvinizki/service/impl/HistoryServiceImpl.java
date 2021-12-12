package com.senla.haltvinizki.service.impl;

import com.senla.haltvinizki.dao.HistoryDao;
import com.senla.haltvinizki.dto.history.HistoryInfoDto;
import com.senla.haltvinizki.dto.history.HistoryWithCustomerDto;
import com.senla.haltvinizki.dto.history.HistoryWithProductDto;
import com.senla.haltvinizki.entity.History;
import com.senla.haltvinizki.service.HistoryService;
import com.senla.haltvinizki.service.converter.HistoryConverter;
import com.senla.haltvinizki.service.exception.HistoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;


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
        final History history = ofNullable(historyDao.getById(id))
                .orElseThrow(() -> new HistoryNotFoundException(id));
        return historyConverter.convert(history);
    }

    @Override
    public HistoryWithProductDto getHistoryWithProduct(Long id) {
        HistoryWithProductDto historyWithProductDto = historyConverter.convertWithProduct(historyDao.getHistoryWithProduct(id));
        return historyWithProductDto;
    }

    @Override
    public HistoryWithCustomerDto getHistoryWithCustomer(Long id) {
        HistoryWithCustomerDto historyWithCustomerDto = historyConverter.convertWithCustomer(historyDao.getHistoryWithCustomer(id));
        return historyWithCustomerDto;
    }

    @Override
    public List<HistoryInfoDto> getByUserId(long id) {
        return historyConverter.convert(historyDao.getByUserId(id));
    }

    @Override
    public HistoryInfoDto getByProductId(Long productId,Long userId) {
       return historyConverter.convert(historyDao.getByProductId(productId,userId));
    }
}
