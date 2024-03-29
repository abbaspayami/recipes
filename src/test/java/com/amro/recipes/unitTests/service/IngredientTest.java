package com.amro.recipes.unitTests.service;


import com.amro.recipes.dao.repository.IngredientsRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * testing service layer
 * @author Abbas
 */
@ExtendWith(SpringExtension.class)
public class IngredientTest {

    @MockBean
    private IngredientsRepository ingredientsRepository;

}
