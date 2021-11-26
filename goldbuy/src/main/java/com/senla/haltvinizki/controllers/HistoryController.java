package com.senla.haltvinizki.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
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

    @PostMapping
    public HistoryInfoDto createHistory(@RequestBody HistoryInfoDto historyInfoDto) {
        return historyService.create(historyInfoDto);
    }

    @GetMapping(value = "/{id}")
    public HistoryInfoDto getById(@PathVariable Long id) {
        return historyService.getById(id);
    }

    @PutMapping
    public HistoryInfoDto updateHistory(@RequestBody HistoryInfoDto historyInfoDto) {
        return historyService.update(historyInfoDto);
    }

    @DeleteMapping(value = "/{id}")
    public HistoryInfoDto deleteHistory(@PathVariable Long id) {
        return historyService.delete(id);
    }
}
