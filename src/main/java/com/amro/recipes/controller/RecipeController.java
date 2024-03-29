package com.amro.recipes.controller;

import com.amro.recipes.dto.RecipeDto;
import com.amro.recipes.dto.RecipeSearchDto;
import com.amro.recipes.service.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    /**
     * adding new recipe
     */
    @Operation(description = "Adding New recipe")
    @PostMapping
    public ResponseEntity<?> add(@RequestBody
                    @Valid RecipeDto recipeDto) {
        log.debug("Request save new Recipe...");
        return new ResponseEntity<>(recipeService.add(recipeDto), HttpStatus.CREATED);
    }

    /**
     * search specific recipe
     */
    @Operation(description = "searching recipe")
    @GetMapping(value = "/search")
    public ResponseEntity<?> search(
            RecipeSearchDto recipeSearchDto) {
        log.debug("searching Recipes...");
        return new ResponseEntity<>(recipeService.search(recipeSearchDto), HttpStatus.OK);
    }

    /**
     * get all recipes
     *
     * @return all recipes
     */
    @Operation(description = "Find all recipes")
    @GetMapping
    public ResponseEntity<?> getAll() {
        log.debug("Request get all ingredient...");
        return new ResponseEntity<>(recipeService.getAll(), HttpStatus.OK);
    }

    /**
     * update recipe
     * @param id recipeId
     * @param recipeDto RecipeDTO
     * @return
     */
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable final long id, @RequestBody RecipeDto recipeDto) {
        log.debug("Request Update for recipeId {}", id);
        return new ResponseEntity<>(recipeService.update(id, recipeDto), HttpStatus.OK);
    }

    /**
     * remove recipe
     * @param id recipeId
     */
    @DeleteMapping(value = "/remove/{id}")
    public void removeProduct(@PathVariable final long id) {
        log.debug("Request remove for recipeId {}", id);
        recipeService.removeRecipe(id);
        ResponseEntity.noContent();
    }

}
