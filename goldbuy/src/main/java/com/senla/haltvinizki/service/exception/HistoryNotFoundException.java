package com.senla.haltvinizki.service.exception;

import lombok.Getter;

public class HistoryNotFoundException extends RuntimeException {
    @Getter
    private final Long id;

    public HistoryNotFoundException(Long id) {
        this.id = id;
    }
}
