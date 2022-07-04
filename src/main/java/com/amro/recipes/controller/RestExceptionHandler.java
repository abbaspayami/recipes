package com.amro.recipes.controller;

import com.amro.recipes.dto.ExceptionDto;
import com.amro.recipes.exceptions.IngredientAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Rest Controller Advice
 *
 * @author Abbas
 */
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * Handles IngredientAlreadyExistException
     * @param ex catch Exception
     * @return An ExceptionDto
     */
    @ExceptionHandler({IngredientAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handleCard(Exception ex) {
        return new ExceptionDto(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
