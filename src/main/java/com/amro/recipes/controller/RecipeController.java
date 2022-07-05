package com.amro.recipes.controller;

import com.amro.recipes.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

//    @PostMapping(value = "/withdrawal")
//    public ResponseEntity<ATMResponseDto> withdrawal(@RequestBody
//                                                     @Valid ATMRequestDto atmRequestDto) {
//        return new ResponseEntity<>(atmMapper.map(atmService.withdrawal(atmRequestDto)), HttpStatus.OK);
//    }

    /**
     * Finding Type Foods
     * @return Type foods
     */
//    @GetMapping(value = "/recipes/typeFoods")
//    public ResponseEntity<List<FoodType>> getTypeFoods() {
//        log.debug("Get typeFoods");
//        return new ResponseEntity<>(recipeService.getTypeFoods(), HttpStatus.OK);
//    }

}
