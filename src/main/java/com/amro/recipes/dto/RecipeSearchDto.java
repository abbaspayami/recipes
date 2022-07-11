package com.amro.recipes.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeSearchDto {

    private String foodType;

    private Integer serve;

    private List<String> hasIngredients;

    private List<String> hasNotIngredients;

    private List<String> hasInstruction;

}
