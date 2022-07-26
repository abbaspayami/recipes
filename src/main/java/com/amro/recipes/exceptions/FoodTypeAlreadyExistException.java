package com.amro.recipes.exceptions;


/**
 * To throw if users want to add Food Category are already exist
 *
 * @author Abbas
 */
public class FoodTypeAlreadyExistException extends RuntimeException {

    /**
     * constructor
     *
     * @param message given message
     */
    public FoodTypeAlreadyExistException(String message) {
        super(message);
    }
}
