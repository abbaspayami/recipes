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

@Validated
@Slf4j
@RestController
@RequestMapping("/api/v1/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    /**
     * adding new ingredient
     */
    @ApiOperation(value = "Adding New Ingredient")
    @PostMapping
    public ResponseEntity<?> add(@RequestBody
                    @Valid IngredientDto ingredientDto) {
        log.debug("Request save new Ingredient {} : ", ingredientDto.getIngredient());
        return new ResponseEntity<>(ingredientService.add(ingredientDto), HttpStatus.CREATED);
    }

    /**
     * indicates the all ingredients
     *
     * @return current status
     */
    @ApiOperation(value = "Find all ingredients")
    @GetMapping
    public ResponseEntity<?> getAll() {
        log.debug("Request get all ingredient...");
        return new ResponseEntity<>(ingredientService.getAll(), HttpStatus.OK);
    }

    /**
     * update Ingredient
     * @param id IngredientId
     * @param ingredientDto IngredientDto
     * @return
     */
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable final int id, @RequestBody IngredientDto ingredientDto) {
        log.debug("Request Update for ingredient {}", id);
        return new ResponseEntity<>(ingredientService.update(id, ingredientDto), HttpStatus.OK);
    }

    /**
     * remove recipe
     * @param id recipeId
     */
    @DeleteMapping(value = "/remove/{id}")
    public void removeProduct(@PathVariable final int id) {
        log.debug("Request remove for recipeId {}", id);
        ingredientService.removeIngredient(id);
        ResponseEntity.noContent();
    }

}
