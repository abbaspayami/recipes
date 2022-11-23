package com.amro.recipes.service;

import com.amro.recipes.dao.entity.FoodType;
import com.amro.recipes.dao.entity.Ingredient;
import com.amro.recipes.dao.entity.Recipe;
import com.amro.recipes.dao.entity.RecipeIngredient;
import com.amro.recipes.dao.repository.FoodTypeRepository;
import com.amro.recipes.dao.repository.IngredientsRepository;
import com.amro.recipes.dao.repository.RecipeIngredientRepository;
import com.amro.recipes.dao.repository.RecipeRepository;
import com.amro.recipes.dto.RecipeDto;
import com.amro.recipes.dto.RecipeResponseDto;
import com.amro.recipes.dto.RecipeSearchDto;
import com.amro.recipes.exceptions.FoodTypeNotFoundException;
import com.amro.recipes.exceptions.IngredientNotFoundException;
import com.amro.recipes.exceptions.RecipeNotFoundException;
import com.amro.recipes.mapper.RecipeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private final RecipeMapper recipeMapper;

//    @Transactional
    public Recipe add(RecipeDto recipeDto) {
        log.info("adding Recipe...");
        Recipe recipe = recipeMapper.recipeDtoToRecipe(recipeDto);
        recipe.setFoodTypeId(getFoodType(recipeDto.getFoodType()));
        Recipe recipeSaved = recipeRepository.save(recipe);
        saveRecipeIngredients(recipeDto, recipeSaved);
        return recipeSaved;
    }

    public List<Recipe> search(RecipeSearchDto recipeSearchDto) {
        List<Recipe> recipes = new ArrayList<>();
        //HasIngredient
        Ingredient hasIngredient = getIngredient(recipeSearchDto.getHasIngredient());
        //HasNotIngredient
        Ingredient hasNotIngredient = getIngredient(recipeSearchDto.getHasNotIngredient());
        List<Recipe> recipeList = recipeRepository.findAll();
        for (Recipe recipe : recipeList) {
            List<RecipeIngredient> recipeIngredientList = recipeIngredientRepository.findAll(new RecipeSpecification().search(recipe.getId(), recipeSearchDto.getFoodType(), recipeSearchDto.getServe()
                    , recipeSearchDto.getInstruction(), hasIngredient.getId(), hasNotIngredient.getId()));
            if (!recipeIngredientList.isEmpty()) {
                recipes.add(recipe);
            }
        }
        return recipes;
    }

    public List<RecipeResponseDto> getAll() {
        return recipeMapper.recipeToRecipeDto(recipeRepository.findAll());
    }

    @Transactional
    public Recipe update(Long id, RecipeDto recipeDto) {
        Recipe recipe = getRecipe(id);
        recipe.setId(id);
        recipe.setFoodTypeId(getFoodType(recipeDto.getFoodType()));
        recipe = recipeMapper.recipeDtoToRecipe(recipeDto);
        recipeRepository.save(recipe);

        List<RecipeIngredient> recipeIngredients = recipeIngredientRepository.findByRfRecipes_Id(recipe.getId());
        recipeIngredientRepository.deleteAll(recipeIngredients);

        saveRecipeIngredients(recipeDto, recipe);

        return getRecipe(id);
    }

    /**
     * deleting recipe
     *
     * @param id recipe Id
     */
    public void removeRecipe(Long id) {
        log.debug("Delete Recipe in id {}", id);
        getRecipe(id);
        recipeRepository.deleteById(id);
    }

    private void saveRecipeIngredients(RecipeDto recipeDto, Recipe recipe) {
        for (Long ingredientId : recipeDto.getIngredients()) {
            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setRfRecipes(recipe);
            Optional<Ingredient> possibleIngredient = ingredientsRepository.findById(ingredientId);
            if (possibleIngredient.isPresent()) {
                recipeIngredient.setRfIngredients(possibleIngredient.get());
                recipeIngredientRepository.save(recipeIngredient);
            }
        }
    }

    public Recipe getRecipe(Long id) {
        log.debug("Get Recipe with id {}", id);
        Optional<Recipe> possibleRecipe = recipeRepository.findById(id);
        return possibleRecipe.orElseThrow(() -> {
            log.debug("RecipeNotFoundException with id {}", id);
            return new RecipeNotFoundException("Recipe Not Found.");
        });
    }

    public FoodType getFoodType(String foodType) {
        Optional<FoodType> possibleFoodType = foodTypeRepository.findByType(foodType);
        return possibleFoodType.orElseThrow(() -> {
            log.debug("FoodTypeNotFoundException with type {}", foodType);
            return new FoodTypeNotFoundException("FoodType Not Found.");
        });
    }

    public Ingredient getIngredient(String ingredient) {
        Optional<Ingredient> possibleIngredient = ingredientsRepository.findByIngredient(ingredient);
        return possibleIngredient.orElseThrow(() -> {
            log.debug("IngredientNotFoundException with ingredient {}", ingredient);
            return new IngredientNotFoundException("Ingredient Not Found.");
        });
    }

}
