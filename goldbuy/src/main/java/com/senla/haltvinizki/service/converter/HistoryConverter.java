package com.senla.haltvinizki.service.converter;

import com.senla.haltvinizki.dto.history.HistoryInfoDto;
import com.senla.haltvinizki.dto.history.HistoryWithCustomerDto;
import com.senla.haltvinizki.dto.history.HistoryWithProductDto;
import com.senla.haltvinizki.entity.History;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoryConverter {
    @Autowired
    private ModelMapper mapper;

    public History convert(HistoryInfoDto historyInfoDto) {
        return mapper.map(historyInfoDto, History.class);
    }

    public HistoryInfoDto convert(History history) {
        return mapper.map(history, HistoryInfoDto.class);
    }

    public History convert(HistoryWithProductDto historyInfoDto) {
        return mapper.map(historyInfoDto, History.class);
    }

    public History convert(HistoryWithCustomerDto historyInfoDto) {
        return mapper.map(historyInfoDto, History.class);
    }

    public HistoryWithCustomerDto convertWithCustomer(History history) {
        return mapper.map(history, HistoryWithCustomerDto.class);
    }

    public HistoryWithProductDto convertWithProduct(History history) {
        return mapper.map(history, HistoryWithProductDto.class);
    }
}