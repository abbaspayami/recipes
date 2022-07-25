package com.amro.recipes.controller;

import com.amro.recipes.dto.FoodTypeDto;
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
@RequestMapping("/api/v1/foodCategories")
@RequiredArgsConstructor
public class FoodTypeController {

    private final FoodCategoriesService foodCategoriesService;

    /**
     * adding new food category
     *
     */
    @ApiOperation(value = "Adding New food category")
    @PostMapping
    public ResponseEntity<?> add(@RequestBody
                    @Valid FoodTypeDto foodTypeDto) {
        log.debug("Request save new  food category {} : ", foodTypeDto.getFoodType());
        return new ResponseEntity<>(foodCategoriesService.add(foodTypeDto), HttpStatus.CREATED);
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
