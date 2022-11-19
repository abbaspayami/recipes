package com.amro.recipes.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RecipeDto {

    @NotNull(message = "is Mandatory")
    @Schema( example = "pizza", required = true)
    private String title;

    @NotNull(message = "is Mandatory")
    @Schema( example = "2", required = true)
    private Integer serve;

    @NotNull(message = "is Mandatory")
    @Schema( example = "you should mix all of them", required = true)
    private String instructions;

    @NotNull(message = "is Mandatory")
//    @Schema( example = "1,2,3", required = true)
    private List<Long> ingredients;

    @NotNull(message = "is Mandatory")
    @Schema( example = "vegetarian", required = true)
    private String foodType;

}
