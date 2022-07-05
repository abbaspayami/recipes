package com.amro.recipes.common;

import com.amro.recipes.dao.model.Ingredients;
import com.amro.recipes.dto.IngredientDto;

public class TestUtils {

    public static final int EXISTING_CART_ID = 1;

    public static Ingredients newIngredient() {
        Ingredients ingredients= new Ingredients();
        ingredients.setIngredient("cucumber");
        ingredients.setId(EXISTING_CART_ID);
        return ingredients;
    }

    public static IngredientDto ingredientDto() {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setIngredient("Potato");
        return ingredientDto;
    }

}
