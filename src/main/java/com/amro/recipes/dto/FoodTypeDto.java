package com.amro.recipes.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FoodTypeDto {

    @NotNull(message = "is Mandatory")
    @Schema( example = "vegetarian", required = true)
    private String foodType;

}
