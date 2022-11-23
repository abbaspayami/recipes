package com.amro.recipes.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class IngredientDto {

    @NotNull(message = "is Mandatory")
    @Schema( example = "oil", required = true)
    private String ingredient;

}
