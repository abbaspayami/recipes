package com.amro.recipes.exceptions;

/**
 * To throw if requested Ingredient does not exist in database
 *
 * @author Abbas
 */
public class IngredientNotFoundException extends RuntimeException{

    /**
     * constructor
     *
     * @param message given message
     */
    public IngredientNotFoundException(String message) {
        super(message);
    }

}