package com.amro.recipes.common;

import com.amro.recipes.dao.model.Ingredient;
import com.amro.recipes.dto.IngredientDto;

public class TestUtils {

    public static final int EXISTING_INGREDIENT_ID = 1;

    public static Ingredient newIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredient("cucumber");
        ingredient.setId(EXISTING_INGREDIENT_ID);
        return ingredient;
    }

    public static IngredientDto ingredientDto() {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setIngredient("potatoes");
        return ingredientDto;
    }

    public static IngredientDto againIngredientDto() {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setIngredient("salmon");
        return ingredientDto;
    }

}
