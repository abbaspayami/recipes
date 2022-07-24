package com.amro.recipes.dao.repository;

import com.amro.recipes.dao.model.Recipe;
import com.amro.recipes.dao.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Integer>, JpaSpecificationExecutor<RecipeIngredient> {

    List<RecipeIngredient> findByRecipes(Integer recipeId);

    void deleteByIngredients_Id(Integer id);

}
