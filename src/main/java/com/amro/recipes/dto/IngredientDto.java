package com.amro.recipes.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class IngredientDto {

    @NotNull(message = "is Mandatory")
    @ApiModelProperty( example = "oil", required = true)
    private String ingredient;

}
