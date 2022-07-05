package com.amro.recipes.dao.repository;

import com.amro.recipes.dao.model.FoodCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCategoriesRepository extends JpaRepository<FoodCategories, Integer> {

    boolean existsFoodCategoriesByFoodType(String ingredient);

}
