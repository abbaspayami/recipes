package com.amro.recipes.exceptions;


/**
 * To throw if users want to add Food Category are already exist
 *
 * @author Abbas
 */
public class FoodCategoryAlreadyExistException extends RuntimeException {

    /**
     * constructor
     *
     * @param message given message
     */
    public FoodCategoryAlreadyExistException(String message) {
        super(message);
    }
}
