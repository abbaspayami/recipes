package com.amro.recipes.dao.repository;

import com.amro.recipes.dao.model.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {

}

