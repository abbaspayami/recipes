package com.amro.recipes.exceptions;

/**
 * To throw if requested recipe does not exists in database
 *
 * @author Abbas
 */
public class RecipeNotFoundException extends RuntimeException{

    /**
     * constructor
     *
     * @param message given message
     */
    public RecipeNotFoundException(String message) {
        super(message);
    }

}