package com.amro.recipes.controller;

import com.amro.recipes.dao.model.FoodCategories;
import com.amro.recipes.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@Slf4j
@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

//    private final FoodCategories foodCategories;

//    @PostMapping(value = "/withdrawal")
//    public ResponseEntity<ATMResponseDto> withdrawal(@RequestBody
//                                                     @Valid ATMRequestDto atmRequestDto) {
//        return new ResponseEntity<>(atmMapper.map(atmService.withdrawal(atmRequestDto)), HttpStatus.OK);
//    }

}
