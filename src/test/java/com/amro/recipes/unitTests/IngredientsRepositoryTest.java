package com.amro.recipes.unitTests;

import com.amro.recipes.common.TestUtils;
import com.amro.recipes.dao.model.Ingredients;
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
public class IngredientsRepositoryTest {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Test
    void SaveIngredientTest() {
        Ingredients ingredients = TestUtils.newIngredient();

        Ingredients saved = ingredientsRepository.save(ingredients);
        assertNotNull(saved);

    }

}
