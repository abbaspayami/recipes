package com.amro.recipes.dao.repository;

import com.amro.recipes.dao.entity.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {

    boolean existsFoodTypeByType(String type);

    Optional<FoodType> findByType(String type);

}
