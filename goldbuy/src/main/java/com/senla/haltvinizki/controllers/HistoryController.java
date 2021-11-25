package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.senla.haltvinizki.controllers.mapper.JsonMapper;
import com.senla.haltvinizki.dto.history.HistoryInfoDto;
import com.senla.haltvinizki.services.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/histories")
@RequiredArgsConstructor
public class HistoryController {
    private HistoryService historyService;
    private JsonMapper gsonMapper;

    @PostMapping
    public String createHistory(String jsonHistory) {
        try {
            HistoryInfoDto historyDto = historyService.create((HistoryInfoDto) gsonMapper.createObj(jsonHistory, HistoryInfoDto.class));
            return gsonMapper.createJson(historyDto);
        } catch (JsonProcessingException e) {
            return "history not delete";
        }
    }

    @GetMapping(value = "/{id}")
    public String getById(int id) {
        return gsonMapper.createJson(historyService.getById(id));
    }

    @PutMapping
    public String updateHistory(@RequestBody String jsonHistory) {

        try {
            HistoryInfoDto historyDto = historyService.update((HistoryInfoDto) gsonMapper.createObj(jsonHistory, HistoryInfoDto.class));
            return gsonMapper.createJson(historyDto);
        } catch (JsonProcessingException e) {
            return "history not update";
        }
    }

    @DeleteMapping(value = "/{id}")
    public String deleteHistory(@RequestBody String jsonHistory) {

        try {
            HistoryInfoDto historyDto = historyService.delete((HistoryInfoDto) gsonMapper.createObj(jsonHistory, HistoryInfoDto.class));
            return gsonMapper.createJson(historyDto);
        } catch (JsonProcessingException e) {
            return "history not delete";
        }
    }
}
