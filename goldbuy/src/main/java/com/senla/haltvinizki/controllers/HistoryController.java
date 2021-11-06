package com.senla.haltvinizki.controllers;


import com.senla.haltvinizki.controllers.mapper.GsonMapper;
import com.senla.haltvinizki.entity.credentials.Credentials;
import com.senla.haltvinizki.entity.history.History;
import com.senla.haltvinizki.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class HistoryController {
    @Autowired
    HistoryService historyService;
    @Autowired
    GsonMapper gsonMapper;

    public String createHistory(String jsonHistory) {
        History history = historyService.create((History) gsonMapper.createObj(jsonHistory, History.class));
        return gsonMapper.createJson(history);
    }

    public String readHistory() {
        return gsonMapper.createJson(historyService.read());
    }

    public String updateHistory(String jsonHistory) {
        History history = historyService.update((History) gsonMapper.createObj(jsonHistory, History.class));
        return gsonMapper.createJson(history);
    }

    public String deleteHistory(String jsonHistory) {
        History history = historyService.delete((History) gsonMapper.createObj(jsonHistory, History.class));
        return gsonMapper.createJson(history);
    }
}
