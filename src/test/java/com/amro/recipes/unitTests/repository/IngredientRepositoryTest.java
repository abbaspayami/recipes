package com.amro.recipes.unitTests.repository;

import com.amro.recipes.common.TestUtils;
import com.amro.recipes.dao.model.Ingredient;
import com.amro.recipes.dao.repository.IngredientsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Data Layer testing
 *
 * @author Abbas
 */
@DataJpaTest
public class IngredientRepositoryTest {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Test
    void SaveIngredientTest() {
        Ingredient ingredient = TestUtils.newIngredient();

        Ingredient saved = ingredientsRepository.save(ingredient);
        assertNotNull(saved);

    }

}
