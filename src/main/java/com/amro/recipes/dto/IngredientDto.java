package com.amro.recipes.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class IngredientDto {

    private Integer id;

    @NotNull(message = "is Mandatory")
    private String ingredient;

}
