package com.amro.recipes.dao.repository;

import com.amro.recipes.dao.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipes, Integer> {

}
