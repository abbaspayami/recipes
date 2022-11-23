package com.amro.recipes.controller;

import com.amro.recipes.dao.entity.FoodType;
import com.amro.recipes.dto.FoodTypeDto;
import com.amro.recipes.service.FoodTypeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@Slf4j
@RestController
@RequestMapping("/api/v1/foodCategories")
@RequiredArgsConstructor
public class FoodTypeController {

    private final FoodTypeService foodTypeService;

    /**
     * adding new food category
     *
     */
    @Operation(description = "Adding New food category")
    @PostMapping
    public ResponseEntity<FoodType> add(@RequestBody
                    @Valid FoodTypeDto foodTypeDto) {
        log.debug("Request save new  food category {} : ", foodTypeDto.getFoodType());
        return new ResponseEntity<>(foodTypeService.add(foodTypeDto), HttpStatus.CREATED);
    }

    /**
     * indicates the all food categories
     *
     * @return all food categories
     */
    @Operation(description = "Find all food categories")
    @GetMapping(value = "/all")
    public ResponseEntity<List<FoodType>> getAll() {
        log.debug("Request get all food categories...");
        return new ResponseEntity<>(foodTypeService.getAll(), HttpStatus.OK);
    }

}
