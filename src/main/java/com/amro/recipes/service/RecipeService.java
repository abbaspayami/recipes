package com.amro.recipes.service;

import com.amro.recipes.dao.model.Recipes;
import com.amro.recipes.dao.model.FoodType;
import com.amro.recipes.dao.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Business Layer
 *
 * @author Abbas
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public List<FoodType> getTypeFoods() {
        log.info("Getting food Types");
        return recipeRepository.findAll()
                .stream()
                .map(Recipes::getFoodType)
                .collect(Collectors.toList());
    }

}
