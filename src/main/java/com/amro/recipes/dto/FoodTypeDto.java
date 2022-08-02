package com.amro.recipes.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FoodTypeDto {

    @NotNull(message = "is Mandatory")
    @ApiModelProperty( example = "vegetarian", required = true)
    private String foodType;

}
