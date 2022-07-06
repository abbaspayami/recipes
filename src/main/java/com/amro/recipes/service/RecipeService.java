package com.amro.recipes.service;

import com.amro.recipes.dao.model.FoodType;
import com.amro.recipes.dao.model.Ingredient;
import com.amro.recipes.dao.model.Recipe;
import com.amro.recipes.dao.repository.FoodCategoriesRepository;
import com.amro.recipes.dao.repository.IngredientsRepository;
import com.amro.recipes.dao.repository.RecipeRepository;
import com.amro.recipes.dto.RecipeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    private final FoodCategoriesRepository foodCategoriesRepository;

//    @Transactional
    public void add(RecipeDto recipeDto) {
        log.info("adding Recipe...");

        Recipe recipe = new Recipe();
        recipe.setInstructions(recipeDto.getInstruction());
        recipe.setServe(recipeDto.getServe());
        recipe.setTitle(recipeDto.getTitle());

        Optional<FoodType> possibleFoodType = foodCategoriesRepository.findByType(recipeDto.getFoodType());
        possibleFoodType.ifPresent(recipe::setRfFoodType);

        // TODO : Use another way to find IDs in order to execute queries in a more efficient way
        List<Ingredient> ingredientList = new ArrayList<>();
        for (Integer ingredientId : recipeDto.getIngredients()) {
            Optional<Ingredient> possibleIngredient = ingredientsRepository.findById(ingredientId);
            possibleIngredient.ifPresent(ingredientList::add);
        }

        recipe.setIngredients(ingredientList);
        recipeRepository.save(recipe);
    }

    public List<String> getAll() {
        log.debug("get all Ingredient...");

        return ingredientsRepository.findAll()
                .stream()
                .map(Ingredient::getIngredient)
                .collect(Collectors.toList());
    }

}
