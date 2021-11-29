package com.senla.haltvinizki.controller.handler;

import com.senla.haltvinizki.dto.category.CategoryInfoDto;
import com.senla.haltvinizki.service.exception.category.CategoryNotCreatedException;
import com.senla.haltvinizki.service.exception.category.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public CategoryInfoDto errorMessageDto(CategoryNotFoundException categoryNotFoundException) {
        CategoryInfoDto errorMessageDto = CategoryInfoDto.builder()
                .name("Категория с id=" + categoryNotFoundException.getId() + " не найден").build();
        return errorMessageDto;
    }
//    @ResponseStatus(HttpStatus.CONFLICT)
//    @ExceptionHandler(CategoryNotFoundException.class)
//    public CategoryInfoDto errorMessageDto(CategoryNotCreatedException categoryNotFoundException) {
//        CategoryInfoDto errorMessageDto = CategoryInfoDto.builder()
//                .name("Категория  " +categoryNotFoundException.getName()+ " не cоздана").build();
//        return errorMessageDto;
//    }

//    @ExceptionHandler(RuntimeException.class)
//    public ErrorMessageDto catchRuntimeException() {
//        return new ErrorMessageDto("всё сломалось");
//    }
}
