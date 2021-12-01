package com.senla.haltvinizki.service.exception.category;

import lombok.Getter;

public class CategoryNotFoundException extends RuntimeException {
    @Getter
    private final Long id;

    public CategoryNotFoundException(Long id) {
        this.id = id;
    }
}
