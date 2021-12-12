package com.senla.haltvinizki.controller;


import com.senla.haltvinizki.dto.history.HistoryInfoDto;
import com.senla.haltvinizki.security.entity.UserDetailsWithId;
import com.senla.haltvinizki.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/histories")
public class HistoryController {

    private final HistoryService historyService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HistoryInfoDto createHistory(@RequestBody HistoryInfoDto historyInfoDto) {
        return historyService.create(historyInfoDto);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HistoryInfoDto getById(@PathVariable Long id) {
        return historyService.getById(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HistoryInfoDto updateHistory(@RequestBody HistoryInfoDto historyInfoDto) {
        return historyService.update(historyInfoDto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HistoryInfoDto deleteHistory(@PathVariable Long id) {
        return historyService.delete(id);
    }

    @GetMapping(value = "/my/{page}/{size}")
    public List<HistoryInfoDto> getByUserId(@AuthenticationPrincipal UserDetailsWithId userDetailsWithId,
                                            @PathVariable int page, @PathVariable int size) {
        List<HistoryInfoDto> historyInfoDtos = historyService.getByUserId(userDetailsWithId.getId());
        return historyInfoDtos.subList(page * size, Math.min(historyInfoDtos.size(), (page + 1) * size));
    }

    @GetMapping(value = "/product/{id}")
    public HistoryInfoDto getByProductId(@AuthenticationPrincipal UserDetailsWithId userDetailsWithId, @PathVariable Long id) {
     HistoryInfoDto infoDto=historyService.getByProductId(id,userDetailsWithId.getId());

      return  historyService.getByProductId(id,userDetailsWithId.getId());
    }//todo


}
