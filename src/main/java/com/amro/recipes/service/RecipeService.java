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
import com.amro.recipes.dto.RecipeResponseDto;
import com.amro.recipes.dto.RecipeSearchDto;
import com.amro.recipes.exceptions.RecipeNotFoundException;
import com.amro.recipes.mapper.RecipeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Transactional
    public Recipe add(RecipeDto recipeDto) {
        log.info("adding Recipe...");
        Recipe recipe = recipeMapper.recipeDtoToRecipe(recipeDto);
        Optional<FoodType> possibleFoodType = foodTypeRepository.findByType(recipeDto.getFoodType());
        possibleFoodType.ifPresent(recipe::setRfFoodType);

        Recipe recipeSaved = recipeRepository.save(recipe);
        saveRecipeIngredients(recipeDto, recipeSaved);
        return recipeSaved;
    }

    public List<Recipe> search(RecipeSearchDto recipeSearchDto) {
        //HasIngredient
        List<Integer> ingredientIds = new ArrayList<>();
        for (String ingredient : recipeSearchDto.getHasIngredients()) {
            Optional<Ingredient> possibleIngredient = ingredientsRepository.findByIngredient(ingredient);
            possibleIngredient.ifPresent(value -> ingredientIds.add(value.getId()));
        }
        //HasNotIngredient
        List<Integer> notIngredientIds = new ArrayList<>();
        for (String ingredient : recipeSearchDto.getHasNotIngredients()) {
            Optional<Ingredient> possibleNotIngredient = ingredientsRepository.findByIngredient(ingredient);
            possibleNotIngredient.ifPresent(value -> notIngredientIds.add(value.getId()));
        }
        List<RecipeIngredient> recipeIngredientList = recipeIngredientRepository.findAll(new RecipeSpecification().search(recipeSearchDto.getFoodType(), recipeSearchDto.getServe()
                , recipeSearchDto.getInstruction(), ingredientIds, notIngredientIds));
//        List<Recipe> recipes = new ArrayList<>();
        return recipeIngredientList.stream().map(RecipeIngredient::getRecipes).distinct().collect(Collectors.toList());
//        for (Recipe recipe : recipeIngredientList.stream().map(RecipeIngredient::getRecipes).collect(Collectors.toList())) {
//            Optional<Recipe> possibleRecipe = recipeRepository.findById(recipe.getId());
//            possibleRecipe.ifPresent(recipes::add);
//        }
//        return recipes;
    }

    public List<RecipeResponseDto> getAll() {
        return recipeMapper.recipeToRecipeDto(recipeRepository.findAll());
    }

    @Transactional
    public List<Recipe> update(Integer id, RecipeDto recipeDto) {
        Recipe recipe = getRecipe(id);
        Optional<FoodType> possibleFoodType = foodTypeRepository.findByType(recipeDto.getFoodType());
        possibleFoodType.ifPresent(recipe::setRfFoodType);
        recipe.setTitle(recipe.getTitle());
        recipe.setServe(recipe.getServe());
        recipe.setInstructions(recipe.getInstructions());
        recipeRepository.save(recipe);

        List<RecipeIngredient> recipeIngredients = recipeIngredientRepository.findByRecipes(recipe.getId());
        recipeIngredientRepository.deleteAll(recipeIngredients);

        saveRecipeIngredients(recipeDto, recipe);

        return recipeRepository.findAll();
    }

    /**
     * deleting recipe
     *
     * @param id recipe Id
     */
    public void removeRecipe(Integer id) {
        log.debug("Delete Recipe in id {}", id);
        getRecipe(id);
        recipeRepository.deleteById(id);
    }

    private void saveRecipeIngredients(RecipeDto recipeDto, Recipe recipe) {
        for (Integer ingredientId : recipeDto.getIngredients()) {
            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setRecipes(recipe);
            Optional<Ingredient> possibleIngredient = ingredientsRepository.findById(ingredientId);
            if (possibleIngredient.isPresent()) {
                recipeIngredient.setIngredients(possibleIngredient.get());
                recipeIngredientRepository.save(recipeIngredient);
            }
        }
    }

    public Recipe getRecipe(Integer id) {
        log.debug("Get Recipe with id {}", id);
        Optional<Recipe> possibleRecipe = recipeRepository.findById(id);
        return possibleRecipe.orElseThrow(() -> {
            log.debug("RecipeNotFoundException with id {}", id);
            return new RecipeNotFoundException("Recipe Not Found.");
        });
    }

}
