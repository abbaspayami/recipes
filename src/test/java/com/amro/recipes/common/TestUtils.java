package com.amro.recipes.common;

import com.amro.recipes.dao.model.FoodType;
import com.amro.recipes.dao.model.Ingredient;
import com.amro.recipes.dao.model.Recipe;
import com.amro.recipes.dto.FoodTypeDto;
import com.amro.recipes.dto.IngredientDto;
import com.amro.recipes.dto.RecipeDto;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static final long EXISTING_RECIPE_ID = 1;
    public static final long NON_EXISTING_RECIPE_ID = 2;
    public static final long EXISTING_INGREDIENT_ID = 1;
    public static final long NON_EXISTING_INGREDIENT_ID = 2;
    public static final String EXISTING_FOOD_TYPE = "vegetarian";
    public static final String NON_EXISTING_FOOD_TYPE = "noting";

    public static Ingredient newIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredient("cucumber");
        ingredient.setId(EXISTING_INGREDIENT_ID);
        return ingredient;
    }

    public static Recipe newRecipe() {
        Recipe recipe= new Recipe();
        recipe.setId(1l);
        recipe.setInstructions("test, test");
        recipe.setTitle("pizza");
//        recipe.setServe(2);
        FoodType foodType =new FoodType();
        foodType.setType("vegetarian");
        recipe.setRfFoodType(foodType);
        return recipe;
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
        recipeDto.setFoodType("vegetarian");
        recipeDto.setInstructions("test, test");
        recipeDto.setServe(2);
        recipeDto.setTitle("pizza");
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        recipeDto.setIngredients(list);
        return recipeDto;
    }

    public static FoodTypeDto newFoodTypeDto(){
        FoodTypeDto foodTypeDto = new FoodTypeDto();
        foodTypeDto.setFoodType("vegetarian");
        return foodTypeDto;
    }
    public static FoodTypeDto newAgainFoodTypeDto(){
        FoodTypeDto foodTypeDto = new FoodTypeDto();
        foodTypeDto.setFoodType("vegan");
        return foodTypeDto;
    }

    public static FoodType newFoodType() {
        FoodType foodType= new FoodType();
        foodType.setId(1L);
        foodType.setType("vegetarian");
        return foodType;
    }


}
