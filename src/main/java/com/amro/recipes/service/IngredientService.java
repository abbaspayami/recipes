package com.amro.recipes.service;

import com.amro.recipes.dao.entity.Ingredient;
import com.amro.recipes.dao.repository.IngredientsRepository;
import com.amro.recipes.dao.repository.RecipeIngredientRepository;
import com.amro.recipes.dto.IngredientDto;
import com.amro.recipes.exceptions.IngredientAlreadyExistException;
import com.amro.recipes.exceptions.IngredientNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientsRepository ingredientsRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;


    public Ingredient add(IngredientDto ingredientDto) {
        log.info("adding Ingredient...");
        checkingIngredientIsExist(ingredientDto.getIngredient());
        return saveIngredient(ingredientDto.getIngredient());
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

    private Ingredient saveIngredient(String ingredient) {
        log.info("Starting to save ingredient in db...");
        var ingredients = new Ingredient();
        ingredients.setIngredient(ingredient);
        Ingredient ingredientSaved = ingredientsRepository.save(ingredients);
        log.info("Ingredient saved to db successfully.");
        return ingredientSaved;
    }

    public Ingredient update(Long id, IngredientDto ingredientDto) {
        Ingredient ingredient = getIngredient(id);
        ingredient.setIngredient(ingredientDto.getIngredient());
        return ingredientsRepository.save(ingredient);
    }

    /**
     * deleting Ingredient
     *
     * @param id Ingredient Id
     */
    public void removeIngredient(Long id) {
        log.debug("Delete Ingredient in id {}", id);
        getIngredient(id);
        ingredientsRepository.deleteById(id);
        recipeIngredientRepository.deleteByRfIngredients_Id(id);
    }

    public Ingredient getIngredient(Long id) {
        log.debug("Get Recipe with id {}", id);
        Optional<Ingredient> possibleIngredient = ingredientsRepository.findById(id);
        return possibleIngredient.orElseThrow(() -> {
            log.debug("IngredientNotFoundException with id {}", id);
            return new IngredientNotFoundException("Ingredient Not Found.");
        });
    }

}
