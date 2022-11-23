package com.amro.recipes.controller;

import com.amro.recipes.dto.ExceptionDto;
import com.amro.recipes.exceptions.*;
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
     * Handles AlreadyExistException
     *
     * @param ex catch Exception
     * @return An ExceptionDto
     */
    @ExceptionHandler({FoodTypeAlreadyExistException.class, IngredientAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handleAlreadyExist(Exception ex) {
        return new ExceptionDto(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles NotFoundException
     *
     * @param ex catch Exception
     * @return An ExceptionDto
     */
    @ExceptionHandler({FoodTypeNotFoundException.class, IngredientNotFoundException.class, RecipeNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handleNotFound(Exception ex) {
        return new ExceptionDto(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
