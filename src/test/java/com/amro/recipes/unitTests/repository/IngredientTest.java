package com.amro.recipes.unitTests.repository;

import com.amro.recipes.common.TestUtils;
import com.amro.recipes.dao.entity.Ingredient;
import com.amro.recipes.dao.repository.IngredientsRepository;
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
public class IngredientTest {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Test
    void SaveIngredientTest() {
        Ingredient ingredient = TestUtils.newIngredient();

        Ingredient saved = ingredientsRepository.save(ingredient);
        assertNotNull(saved);

        Optional<Ingredient> optionalIngredient = ingredientsRepository.findById(saved.getId());

        assertTrue(optionalIngredient.isPresent());

        Ingredient ingredienT = optionalIngredient.get();
        assertEquals(TestUtils.EXISTING_INGREDIENT_ID, ingredienT.getId());
    }

}
