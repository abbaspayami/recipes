package com.amro.recipes.service;

import com.amro.recipes.dao.model.RecipeIngredient;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecipeSpecification {

    public Specification<RecipeIngredient> search(String foodType, Integer serve, String instruction, List<Integer> hasIngredient, List<Integer> hasNotIngredient) {
        return Specification.where(serve(serve))
                .and(hasIngredient(hasIngredient))
                .and(hasNotIngredient(hasNotIngredient))
                .and(instruction(instruction))
                .and(foodType(foodType));
    }

    public Specification<RecipeIngredient> hasIngredient(List<Integer> hasIngredients) {
        return (root, query, cb) -> {
            if (hasIngredients == null || hasIngredients.isEmpty()) {
                return null;
            }
            return root.get("ingredients").get("id").in(hasIngredients);
        };
    }

    public Specification<RecipeIngredient> hasNotIngredient(List<Integer> hasNotIngredient) {
        return (root, query, cb) -> {
            if (hasNotIngredient == null || hasNotIngredient.isEmpty()) {
                return null;
            }
            return root.get("ingredients").get("id").in(hasNotIngredient).not();
        };
    }

    public Specification<RecipeIngredient> serve(Integer serve) {
        return (root, query, cb) -> {
            if (serve == null) {
                return null;
            }
            return cb.equal(root.get("recipes").get("serve"), serve);
        };
    }

    public Specification<RecipeIngredient> instruction(String instruction) {
        return (root, query, cb) -> {
            if (instruction == null) {
                return null;
            }
            return cb.like(cb.lower(root.get("recipes").get("instructions")), "%" + instruction + "%");
        };
    }

    public Specification<RecipeIngredient> foodType(String foodType) {
        return (root, query, cb) -> {
            if (foodType == null) {
                return null;
            }
            return cb.equal(root.get("recipes").get("rfFoodType").get("type"), foodType);
        };
    }

}
