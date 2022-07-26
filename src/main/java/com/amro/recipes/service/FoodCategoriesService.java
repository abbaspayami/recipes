package com.amro.recipes.service;

import com.amro.recipes.dao.model.FoodType;
import com.amro.recipes.dao.repository.FoodTypeRepository;
import com.amro.recipes.dto.FoodTypeDto;
import com.amro.recipes.exceptions.FoodTypeAlreadyExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodCategoriesService {

    private final FoodTypeRepository foodTypeRepository;

    public FoodType add(FoodTypeDto foodTypeDto) {
        log.info("adding Food Type...");
        checkingFoodCategoriesIsExist(foodTypeDto.getFoodType());
        return saveFoodCategories(foodTypeDto.getFoodType());
    }

    public List<FoodType> getAll() {
        log.debug("get all Ingredient...");

        return foodTypeRepository.findAll();
    }

    public void checkingFoodCategoriesIsExist(String foodType) {
        log.info("checking Ingredient is already Exist...");
        if (foodTypeRepository.existsFoodTypeByType(foodType)) {
            throw new FoodTypeAlreadyExistException("The Food Type is already exist in the database: ");
        }
    }

    private FoodType saveFoodCategories(String foodType) {
        log.info("Starting to save ingredient in db...");
        var foodCategories = new FoodType();
        foodCategories.setType(foodType);
        FoodType foodTypeSaved = foodTypeRepository.save(foodCategories);
        log.info("Food Category saved to db successfully.");
        return foodTypeSaved;
    }

}
