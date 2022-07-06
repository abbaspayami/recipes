package com.amro.recipes.service;

import com.amro.recipes.dao.model.Ingredient;
import com.amro.recipes.dao.repository.IngredientsRepository;
import com.amro.recipes.dto.IngredientDto;
import com.amro.recipes.exceptions.IngredientAlreadyExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientsRepository ingredientsRepository;


    public void add(IngredientDto ingredientDto) {
        log.info("adding Ingredient...");
        checkingIngredientIsExist(ingredientDto.getIngredient());
        saveIngredient(ingredientDto.getIngredient());
    }

    public List<Ingredient> getAll() {
        log.debug("get all Ingredient...");

        return ingredientsRepository.findAll();
    }

    public void checkingIngredientIsExist(String ingredient) {
        log.info("checking Ingredient is already Exist...");
        if (ingredientsRepository.existsIngredientsByIngredient(ingredient)) {
            throw new IngredientAlreadyExistException("The Ingredient is already exist in the database: ");
        }
    }

    private void saveIngredient(String ingredient) {
        log.info("Starting to save ingredient in db...");
        var ingredients = new Ingredient();
        ingredients.setIngredient(ingredient);
        ingredientsRepository.save(ingredients);
        log.info("Ingredient saved to db successfully.");
    }

}
