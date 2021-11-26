package com.senla.haltvinizki.services.converter;

import com.senla.haltvinizki.dto.history.HistoryInfoDto;
import com.senla.haltvinizki.dto.history.HistoryWithCustomerDto;
import com.senla.haltvinizki.dto.history.HistoryWithProductDto;
import com.senla.haltvinizki.entity.History;
import org.modelmapper.ModelMapper;

public class HistoryConverter {
    ModelMapper mapper = new ModelMapper();

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
