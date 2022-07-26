package com.amro.recipes.mapper;

import com.amro.recipes.dao.model.Recipe;
import com.amro.recipes.dto.RecipeDto;
import com.amro.recipes.dto.RecipeResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    Recipe recipeDtoToRecipe(RecipeDto recipeDto);

    List<RecipeResponseDto> recipeToRecipeDto(List<Recipe> recipes);

    Recipe recipeToRecipe(Recipe recipe);

}
