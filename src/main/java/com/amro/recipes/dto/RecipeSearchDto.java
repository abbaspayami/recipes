package com.amro.recipes.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeSearchDto {

    private Integer foodType;

    private Integer serve;

    private List<Integer> hasIngredients;

    private List<Integer> hasNotIngredients;

    private String instruction;

}
