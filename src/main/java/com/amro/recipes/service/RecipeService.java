package com.amro.recipes.service;

import com.amro.recipes.dao.model.FoodType;
import com.amro.recipes.dao.model.Ingredient;
import com.amro.recipes.dao.model.Recipe;
import com.amro.recipes.dao.model.RecipeIngredient;
import com.amro.recipes.dao.repository.FoodTypeRepository;
import com.amro.recipes.dao.repository.IngredientsRepository;
import com.amro.recipes.dao.repository.RecipeIngredientRepository;
import com.amro.recipes.dao.repository.RecipeRepository;
import com.amro.recipes.dto.RecipeDto;
import com.amro.recipes.dto.RecipeSearchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Business Layer
 *
 * @author Abbas
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientsRepository ingredientsRepository;
    private final FoodTypeRepository foodTypeRepository;

    private final RecipeIngredientRepository recipeIngredientRepository;

//    @Transactional
    public Recipe add(RecipeDto recipeDto) {
        log.info("adding Recipe...");

        Recipe recipe = new Recipe();
        recipe.setInstructions(recipeDto.getInstruction());
        recipe.setServe(recipeDto.getServe());
        recipe.setTitle(recipeDto.getTitle());

        Optional<FoodType> possibleFoodType = foodTypeRepository.findByType(recipeDto.getFoodType());
        possibleFoodType.ifPresent(recipe::setRfFoodType);

        Recipe recipeSaved = recipeRepository.save(recipe);

        // TODO : Use another way to find IDs in order to execute queries in a more efficient way

        for (Integer ingredientId : recipeDto.getIngredients()) {
            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setRecipes(recipeSaved);
            Optional<Ingredient> possibleIngredient = ingredientsRepository.findById(ingredientId);
            if (possibleIngredient.isPresent()) {
                recipeIngredient.setIngredients(possibleIngredient.get());
                recipeIngredientRepository.save(recipeIngredient);
            }
        }
        return recipeSaved;
    }

    public List<Recipe> search(RecipeSearchDto recipeSearchDto) {
        return recipeRepository.findAll(new RecipeSpecification().search(recipeSearchDto));
    }

    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

}
