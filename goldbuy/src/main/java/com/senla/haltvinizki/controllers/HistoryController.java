package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.history.HistoryInfoDto;
import com.senla.haltvinizki.services.HistoryService;

public class HistoryController {
    private HistoryService historyService;
    private JsonMapper gsonMapper;

    public String createHistory(String jsonHistory) {
        try {
            HistoryInfoDto historyDto = historyService.create((HistoryInfoDto) gsonMapper.createObj(jsonHistory, HistoryInfoDto.class));
            return gsonMapper.createJson(historyDto);
        } catch (JsonProcessingException e) {
            return "history not delete";
        }
    }

    public String getById(int id) {
        return gsonMapper.createJson(historyService.getById(id));
    }

    public String updateHistory(String jsonHistory) {

        try {
            HistoryInfoDto historyDto = historyService.update((HistoryInfoDto) gsonMapper.createObj(jsonHistory, HistoryInfoDto.class));
            return gsonMapper.createJson(historyDto);
        } catch (JsonProcessingException e) {
            return "history not update";
        }
    }

    public String deleteHistory(String jsonHistory) {

        try {
            HistoryInfoDto historyDto = historyService.delete((HistoryInfoDto) gsonMapper.createObj(jsonHistory, HistoryInfoDto.class));
            return gsonMapper.createJson(historyDto);
        } catch (JsonProcessingException e) {
            return "history not delete";
        }
    }
}
