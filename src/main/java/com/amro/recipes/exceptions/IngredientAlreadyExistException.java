package com.amro.recipes.exceptions;

/**
 * To throw if users want to add ingredients are already exist
 *
 * @author Abbas
 */
public class IngredientAlreadyExistException extends RuntimeException {

    /**
     * constructor
     *
     * @param message given message
     */
    public IngredientAlreadyExistException(String message) {
        super(message);
    }
}
