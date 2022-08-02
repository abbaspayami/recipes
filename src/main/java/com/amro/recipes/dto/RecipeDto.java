package com.amro.recipes.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RecipeDto {

    @NotNull(message = "is Mandatory")
    @ApiModelProperty( example = "pizza", required = true)
    private String title;

    @NotNull(message = "is Mandatory")
    @ApiModelProperty( example = "2", required = true)
    private Integer serve;

    @NotNull(message = "is Mandatory")
    @ApiModelProperty( example = "you should mix all of them", required = true)
    private String instructions;

    @NotNull(message = "is Mandatory")
    @ApiModelProperty( example = "1,2,3", required = true)
    private List<Integer> ingredients;

    @NotNull(message = "is Mandatory")
    @ApiModelProperty( example = "vegetarian", required = true)
    private String foodType;

}
