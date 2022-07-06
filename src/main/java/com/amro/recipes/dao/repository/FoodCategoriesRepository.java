package com.amro.recipes.dao.repository;

import com.amro.recipes.dao.model.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodCategoriesRepository extends JpaRepository<FoodType, Integer> {

    boolean existsFoodTypeByType(String type);

    Optional<FoodType> findByType(String type);

}
