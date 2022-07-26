package com.amro.recipes.unitTests.repository;


import com.amro.recipes.common.TestUtils;
import com.amro.recipes.dao.model.Recipe;
import com.amro.recipes.dao.repository.RecipeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Data Layer testing
 *
 * @author Abbas
 */
@DataJpaTest
public class RecipeTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    @DisplayName("save and find Recipe Test")
    void saveAndFindGameTest() {
        Recipe recipe = TestUtils.newRecipe();

        Recipe savedRecipe = recipeRepository.save(recipe);
        assertNotNull(savedRecipe);

        // Fetch saved game
        Optional<Recipe> optionalRecipe = recipeRepository.findById(savedRecipe.getId());

        // Validate fetched recipe
        assertTrue(optionalRecipe.isPresent());

        Recipe reciPe = optionalRecipe.get();
        assertEquals(TestUtils.EXISTING_RECIPE_ID, reciPe.getId());
    }

}
