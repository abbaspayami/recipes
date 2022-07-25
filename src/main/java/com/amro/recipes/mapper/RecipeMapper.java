package com.amro.recipes.mapper;

import com.amro.recipes.dao.model.Recipe;
import com.amro.recipes.dto.RecipeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    Recipe recipeToRecipeDto(RecipeDto recipeDto);

    RecipeDto recipeDtoToRecipe(Recipe recipe);

}
