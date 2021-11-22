package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.HistoryDao;
import com.senla.haltvinizki.dto.history.HistoryInfoDto;
import com.senla.haltvinizki.dto.history.HistoryWithCustomerDto;
import com.senla.haltvinizki.dto.history.HistoryWithProductDto;
import com.senla.haltvinizki.entity.History;
import com.senla.haltvinizki.services.HistoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryDao historyDao;
    @Autowired
    private ModelMapper mapper;

    @Override
    public HistoryInfoDto delete(HistoryInfoDto historyDto) {
        return mapper.map(historyDao.delete(historyDto.getId()), HistoryInfoDto.class);
    }


    @Override
    public HistoryInfoDto create(HistoryInfoDto historyDto) {
        History history = mapper.map(historyDto, History.class);
        return mapper.map(historyDao.create(history), HistoryInfoDto.class);
    }

    @Override
    public HistoryInfoDto update(HistoryInfoDto historyDto) {
        History history = mapper.map(historyDto, History.class);
        return mapper.map(historyDao.update(history), HistoryInfoDto.class);
    }

    @Override
    public HistoryInfoDto getById(int id) {
        History history = historyDao.getById(id);
        return mapper.map(history, HistoryInfoDto.class);
    }

    @Override
    public HistoryWithProductDto getHistoryWithProduct(int id) {
        History history = historyDao.getHistoryWithProduct(id);
        return mapper.map(history,HistoryWithProductDto.class);
    }

    @Override
    public HistoryWithCustomerDto getHistoryWithCustomer(int id) {
        History history = historyDao.getHistoryWithCustomer(id);
        return mapper.map(history,HistoryWithCustomerDto.class);
    }
}
