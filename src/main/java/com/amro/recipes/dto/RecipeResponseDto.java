package com.amro.recipes.dto;

import com.amro.recipes.dao.model.FoodType;
import lombok.Data;


@Data
public class RecipeResponseDto {

    private Integer id;

    private String title;

    private Integer serve;

    private String instructions;

    private FoodType rfFoodType;

}
