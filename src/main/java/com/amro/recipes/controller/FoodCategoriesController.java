package com.amro.recipes.controller;

import com.amro.recipes.dao.model.FoodCategories;
import com.amro.recipes.dao.repository.FoodCategoriesRepository;
import com.amro.recipes.dto.FoodCategoryDto;
import com.amro.recipes.dto.IngredientDto;
import com.amro.recipes.service.FoodCategoriesService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@Slf4j
@RestController
@RequestMapping("/api/foodCategories")
@RequiredArgsConstructor
public class FoodCategoriesController {

    private final FoodCategoriesService foodCategoriesService;

    /**
     * adding new food category
     *
     */
    @ApiOperation(value = "Adding New food category")
    @PostMapping
    public void add(@RequestBody
                    @Valid FoodCategoryDto foodCategoryDto) {
        log.debug("Request save new  food category {} : ", foodCategoryDto.getFoodType());
        foodCategoriesService.add(foodCategoryDto);
        ResponseEntity.status(HttpStatus.CREATED);
    }

    /**
     * indicates the all food categories
     *
     * @return all food categories
     */
    @ApiOperation(value = "Find all food categories")
    @GetMapping(value = "/all")
    public ResponseEntity<?> getAll() {
        log.debug("Request get all food categories...");
        return new ResponseEntity<>(foodCategoriesService.getAll(), HttpStatus.OK);
    }

}
