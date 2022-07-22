package com.amro.recipes.controller;

import com.amro.recipes.dao.model.Recipe;
import com.amro.recipes.dto.RecipeDto;
import com.amro.recipes.dto.RecipeSearchDto;
import com.amro.recipes.service.RecipeService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    /**
     * adding new recipe
     */
    @ApiOperation(value = "Adding New recipe")
    @PostMapping
    public ResponseEntity<?> add(@RequestBody
                    @Valid RecipeDto recipeDto) {
        log.debug("Request save new Recipe...");
        return new ResponseEntity<>(recipeService.add(recipeDto), HttpStatus.CREATED);
    }

    /**
     * search specific recipe
     */
    @ApiOperation(value = "searching recipe")
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
    @ApiOperation(value = "Find all recipes")
    @GetMapping
    public ResponseEntity<?> getAll() {
        log.debug("Request get all ingredient...");
        return new ResponseEntity<>(recipeService.getAll(), HttpStatus.OK);
    }

}
