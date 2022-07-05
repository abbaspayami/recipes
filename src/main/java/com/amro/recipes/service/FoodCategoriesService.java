package com.amro.recipes.service;

import com.amro.recipes.dao.model.FoodCategories;
import com.amro.recipes.dao.model.Ingredients;
import com.amro.recipes.dao.repository.FoodCategoriesRepository;
import com.amro.recipes.dto.FoodCategoryDto;
import com.amro.recipes.dto.IngredientDto;
import com.amro.recipes.exceptions.FoodCategoryAlreadyExistException;
import com.amro.recipes.exceptions.IngredientAlreadyExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodCategoriesService {

    private final FoodCategoriesRepository foodCategoriesRepository;

    public void add(FoodCategoryDto foodCategoryDto) {
        log.info("adding Food Type...");
        checkingFoodCategoriesIsExist(foodCategoryDto.getFoodType());
        saveFoodCategories(foodCategoryDto.getFoodType());
    }

    public List<String> getAll() {
        log.debug("get all Ingredient...");

        return foodCategoriesRepository.findAll()
                .stream()
                .map(FoodCategories::getFoodType)
                .collect(Collectors.toList());
    }

    public void checkingFoodCategoriesIsExist(String foodType) {
        log.info("checking Ingredient is already Exist...");
        if (foodCategoriesRepository.existsFoodCategoriesByFoodType(foodType)) {
            throw new FoodCategoryAlreadyExistException("The Food Type is already exist in the database: ");
        }
    }

    private void saveFoodCategories(String foodType) {
        log.info("Starting to save ingredient in db...");
        var foodCategories = new FoodCategories();
        foodCategories.setFoodType(foodType);
        foodCategoriesRepository.save(foodCategories);
        log.info("Food Category saved to db successfully.");
    }

}
