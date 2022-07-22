package com.amro.recipes.dao.repository;

import com.amro.recipes.dao.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Integer> {

    List<RecipeIngredient> findByRecipes(Integer recipeId);

    void deleteByIngredients_Id(Integer id);

}
