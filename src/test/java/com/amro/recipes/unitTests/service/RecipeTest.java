package com.amro.recipes.unitTests.service;

import com.amro.recipes.common.TestUtils;
import com.amro.recipes.dao.model.FoodType;
import com.amro.recipes.dao.model.Recipe;
import com.amro.recipes.dao.repository.FoodTypeRepository;
import com.amro.recipes.dao.repository.IngredientsRepository;
import com.amro.recipes.dao.repository.RecipeIngredientRepository;
import com.amro.recipes.dao.repository.RecipeRepository;
import com.amro.recipes.dto.RecipeResponseDto;
import com.amro.recipes.exceptions.FoodTypeNotFoundException;
import com.amro.recipes.exceptions.RecipeNotFoundException;
import com.amro.recipes.mapper.RecipeMapper;
import com.amro.recipes.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * testing service layer
 *
 * @author Abbas
 */
@ExtendWith(SpringExtension.class)
public class RecipeTest {

    @MockBean
    private RecipeRepository recipeRepository;
    @MockBean
    private IngredientsRepository ingredientsRepository;
    @MockBean
    private FoodTypeRepository foodTypeRepository;
    @MockBean
    private RecipeIngredientRepository recipeIngredientRepository;
    @MockBean
    private RecipeMapper recipeMapper;

    private RecipeService recipeService;

    private Recipe recipe;
    private FoodType foodType;

    @BeforeEach
    void setUp() {
        recipeService = new RecipeService(recipeRepository, ingredientsRepository, foodTypeRepository, recipeIngredientRepository, recipeMapper);

        recipe = TestUtils.newRecipe();
        foodType = TestUtils.newFoodType();

        when(recipeRepository.findById(TestUtils.EXISTING_RECIPE_ID)).thenReturn(Optional.of(recipe));
        when(recipeRepository.findById(TestUtils.NON_EXISTING_RECIPE_ID)).thenReturn(Optional.empty());
        when(foodTypeRepository.findByType(TestUtils.EXISTING_FOOD_TYPE)).thenReturn(Optional.of(foodType));
        when(foodTypeRepository.findByType(TestUtils.NON_EXISTING_FOOD_TYPE)).thenReturn(Optional.empty());
        when(recipeMapper.recipeDtoToRecipe(TestUtils.recipeDto())).thenReturn(recipe);
        when(recipeRepository.save(any(Recipe.class))).thenReturn(recipe);


    }

    /**
     * loading existing recipes
     */
    @Test
    void loadExistingRecipes() {
        List<RecipeResponseDto> recipeResponseDtos = recipeService.getAll();

        assertNotNull(recipeResponseDtos);
    }

    /**
     * loading existing recipes
     */
    @Test
    void updateRecipes() {
        List<RecipeResponseDto> recipeResponseDtos = recipeService.getAll();

        assertNotNull(recipeResponseDtos);
    }

    /**
     * loading existing recipe
     */
    @Test
    void load_Existing_Product_Test() {
        Recipe recipe = recipeService.getRecipe(TestUtils.EXISTING_RECIPE_ID);

        assertNotNull(recipe);
        assertEquals(TestUtils.EXISTING_RECIPE_ID, recipe.getId());
    }

    /**
     * loading Non existing recipe
     */
    @Test
    void load_NonExisting_Product_Test() {
        Exception exception = assertThrows(RecipeNotFoundException.class, () -> {
            recipeService.getRecipe(TestUtils.NON_EXISTING_RECIPE_ID);
        });
        String expectedMessage = "Recipe Not Found.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    /**
     * loading existing foodType
     */
    @Test
    void load_Existing_FoodType_Test() {
        FoodType foodType = recipeService.getFoodType(TestUtils.EXISTING_FOOD_TYPE);

        assertNotNull(foodType);
        assertEquals(TestUtils.EXISTING_FOOD_TYPE, foodType.getType());
    }

    /**
     * loading Non existing FoodType
     */
    @Test
    void load_NonExisting_FoodType_Test() {
        Exception exception = assertThrows(FoodTypeNotFoundException.class, () -> {
            recipeService.getFoodType(TestUtils.NON_EXISTING_FOOD_TYPE);
        });
        String expectedMessage = "FoodType Not Found.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    /**
     * updating existing recipe
     */
    @Test
    void update_Recipe_Test() {
        Recipe update = recipeService.update(TestUtils.EXISTING_RECIPE_ID, TestUtils.recipeDto());

        assertNotNull(update);
        assertEquals(TestUtils.EXISTING_RECIPE_ID, update.getId());
    }

    /**
     * updating existing recipe
     */
    @Test
    void remove_Recipe_Test() {
        recipeService.removeRecipe(TestUtils.EXISTING_RECIPE_ID);

    }


}
