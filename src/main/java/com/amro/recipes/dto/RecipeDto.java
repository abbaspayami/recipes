package com.amro.recipes.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RecipeDto {

    @NotNull(message = "is Mandatory")
    private String title;

    @NotNull(message = "is Mandatory")
    private Integer serve;

    @NotNull(message = "is Mandatory")
    private String instruction;

    @NotNull(message = "is Mandatory")
    private List<Integer> ingredients;

    @NotNull(message = "is Mandatory")
    private String foodType;

}
