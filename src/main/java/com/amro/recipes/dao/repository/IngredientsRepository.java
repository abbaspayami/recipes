package com.amro.recipes.dao.repository;

import com.amro.recipes.dao.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Integer> {

    boolean existsIngredientsByIngredient(String ingredient);

    Optional<Ingredient> findByIngredient(String ingredient);

}

