package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.entity.history.History;
import com.senla.haltvinizki.services.HistoryService;
import com.senla.haltvinizki.util.Logger;

public class HistoryController {
    private HistoryService historyService;
    private JsonMapper gsonMapper;

    public String createHistory(String jsonHistory) {
        History history = null;
        try {
            history = historyService.create((History) gsonMapper.createObj(jsonHistory, History.class));
            return gsonMapper.createJson(history);
        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "history not delete";
        }
    }

    public String getById(int id) {
        return gsonMapper.createJson(historyService.getById(id));
    }

    public String updateHistory(String jsonHistory) {
        History history = null;
        try {
            history = historyService.update((History) gsonMapper.createObj(jsonHistory, History.class));
            return gsonMapper.createJson(history);
        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "history not update";
        }
    }

    public String deleteHistory(String jsonHistory) {
        History history = null;
        try {
            history = historyService.delete((History) gsonMapper.createObj(jsonHistory, History.class));
            return gsonMapper.createJson(history);

        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "history not delete";
        }
    }
}
