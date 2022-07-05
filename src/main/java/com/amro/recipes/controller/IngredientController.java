package com.amro.recipes.controller;


import com.amro.recipes.dto.IngredientDto;
import com.amro.recipes.service.IngredientService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/api/ingredient")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    /**
     * adding new ingredient
     *
     */
    @ApiOperation(value = "Adding New Ingredient")
    @PostMapping
    public void add(@RequestBody
                        @Valid IngredientDto ingredientDto) {
        log.debug("Request save new Ingredient {} : ", ingredientDto.getIngredient());
        ingredientService.add((ingredientDto));
        ResponseEntity.status(HttpStatus.CREATED);
    }

    /**
     * indicates the all ingredients
     *
     * @return current status
     */
    @ApiOperation(value = "Find all ingredients")
    @GetMapping(value = "/all")
    public ResponseEntity<?> getAll() {
        log.debug("Request get all ingredient...");
        return new ResponseEntity<>(ingredientService.getAll(), HttpStatus.OK);
    }

}
