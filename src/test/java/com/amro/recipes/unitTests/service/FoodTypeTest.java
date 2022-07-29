package com.amro.recipes.unitTests.service;

import com.amro.recipes.common.TestUtils;
import com.amro.recipes.dao.model.FoodType;
import com.amro.recipes.dao.model.Recipe;
import com.amro.recipes.dao.repository.FoodTypeRepository;
import com.amro.recipes.dto.RecipeResponseDto;
import com.amro.recipes.exceptions.FoodTypeAlreadyExistException;
import com.amro.recipes.service.FoodTypeService;
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
public class FoodTypeTest {

    @MockBean
    private FoodTypeRepository foodTypeRepository;

    private FoodTypeService foodTypeService;

    private FoodType foodType;

    @BeforeEach
    void setUp() {
        foodTypeService = new FoodTypeService(foodTypeRepository);

        foodType = TestUtils.newFoodType();

        when(foodTypeRepository.existsFoodTypeByType(TestUtils.EXISTING_FOOD_TYPE)).thenReturn(true);
        when(foodTypeRepository.existsFoodTypeByType(TestUtils.NON_EXISTING_FOOD_TYPE)).thenReturn(false);
        when(foodTypeRepository.save(any(FoodType.class))).thenReturn(foodType);

    }


    /**
     * checking non existing recipe
     */
    @Test
    void loadNonExistingRecipe() {
        Exception exception = assertThrows(FoodTypeAlreadyExistException.class, () -> {
            foodTypeService.checkingFoodTypeIsExist(TestUtils.EXISTING_FOOD_TYPE);
        });
        String expectedMessage = "The Food Type is already exist.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    /**
     * loading existing recipes
     */
    @Test
    void save_Food_Type_Test() {
        FoodType add = foodTypeService.add(TestUtils.newAgainFoodTypeDto());

        assertNotNull(add);
    }

}
