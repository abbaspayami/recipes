package com.amro.recipes.controller;


import com.amro.recipes.dto.IngredientDto;
import com.amro.recipes.service.IngredientService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@Slf4j
@RestController
@RequestMapping("/api/ingredient")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    /**
     * adding new ingredient
     *
     * @return new ingredient
     */
    @ApiOperation(value = "Adding New Ingredient")
    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody
                                     @Valid IngredientDto ingredientDto) {
        ingredientService.add((ingredientDto));
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.CREATED);
    }

}
