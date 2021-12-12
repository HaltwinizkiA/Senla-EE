package com.senla.haltvinizki.service.exception;

import lombok.Getter;

public class HistoryNotFoundException extends RuntimeException {
    @Getter
    private Long id;

    public HistoryNotFoundException() {

    }


    public HistoryNotFoundException(Long id) {
        this.id = id;
    }
}
