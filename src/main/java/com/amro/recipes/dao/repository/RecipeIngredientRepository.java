package com.amro.recipes.dao.repository;

import com.amro.recipes.dao.model.Recipe;
import com.amro.recipes.dao.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long>, JpaSpecificationExecutor<RecipeIngredient> {

    List<RecipeIngredient> findByRfRecipes_Id(Long recipeId);

    void deleteByRfIngredients_Id(Long id);

}
