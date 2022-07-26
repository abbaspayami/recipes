package com.amro.recipes.exceptions;

/**
 * To throw if requested FoodType does not exist in database
 *
 * @author Abbas
 */
public class FoodTypeNotFoundException extends RuntimeException{

    /**
     * constructor
     *
     * @param message given message
     */
    public FoodTypeNotFoundException(String message) {
        super(message);
    }

}