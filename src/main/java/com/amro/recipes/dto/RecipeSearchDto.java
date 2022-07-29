package com.amro.recipes.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeSearchDto {

    private String foodType;

    private Integer serve;

    private String hasIngredient;

    private String hasNotIngredient;

    private String instruction;

}
