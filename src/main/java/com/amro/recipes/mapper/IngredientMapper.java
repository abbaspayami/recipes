package com.amro.recipes.mapper;

import com.amro.recipes.dao.entity.Ingredient;
import com.amro.recipes.dto.IngredientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    Ingredient IngredientToIngredientDto(IngredientDto ingredientDto);

    IngredientDto IngredientDtoToIngredient(Ingredient ingredient);

}
