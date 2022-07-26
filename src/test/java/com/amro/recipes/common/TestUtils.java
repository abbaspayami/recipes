package com.amro.recipes.common;

import com.amro.recipes.dao.model.Ingredient;
import com.amro.recipes.dto.IngredientDto;
import com.amro.recipes.dto.RecipeDto;

import java.util.ArrayList;
import java.util.List;

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

    public static RecipeDto recipeDto() {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setFoodType("vegan");
        recipeDto.setInstructions("test, test");
        recipeDto.setServe(2);
        recipeDto.setTitle("pizza");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        recipeDto.setIngredients(list);
        return recipeDto;
    }

}
