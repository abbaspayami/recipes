package com.amro.recipes.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RecipeSearchDto {

    @Schema( example = "vegetarian")
    private String foodType;

    @Schema( example = "4")
    private Integer serve;

    @Schema( example = "potatoes")
    private String hasIngredient;

    @Schema( example = "salmon")
    private String hasNotIngredient;

    @Schema( example = "oven")
    private String instruction;

}
