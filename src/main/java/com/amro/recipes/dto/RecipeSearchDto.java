package com.amro.recipes.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class RecipeSearchDto {

    @ApiModelProperty( example = "vegetarian")
    private String foodType;

    @ApiModelProperty( example = "4")
    private Integer serve;

    @ApiModelProperty( example = "potatoes")
    private String hasIngredient;

    @ApiModelProperty( example = "salmon")
    private String hasNotIngredient;

    @ApiModelProperty( example = "oven")
    private String instruction;

}
