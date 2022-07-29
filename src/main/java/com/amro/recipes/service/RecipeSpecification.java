package com.amro.recipes.service;

import com.amro.recipes.dao.model.RecipeIngredient;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecipeSpecification {

    public Specification<RecipeIngredient> search(Integer recipeId, String foodType, Integer serve, String instruction,
                                                  Integer hasIngredient, Integer hasNotIngredient) {
        return Specification.where(serve(serve))
                .and(recipe(recipeId))
                .and(hasIngredient(hasIngredient))
                .and(hasNotIngredient(hasNotIngredient))
                .and(instruction(instruction))
                .and(foodType(foodType));
    }

    public Specification<RecipeIngredient> recipe(Integer recipeId) {
        return (root, query, cb) -> {
            if (recipeId == null) {
                return null;
            }
            return cb.equal(root.get("recipes").get("id"), recipeId);
        };
    }

    public Specification<RecipeIngredient> hasIngredient(Integer hasIngredients) {
        return (root, query, cb) -> {
            if (hasIngredients == null) {
                return null;
            }
            return cb.equal(root.get("ingredients").get("id"), hasIngredients);
        };
    }

    public Specification<RecipeIngredient> hasNotIngredient(Integer hasNotIngredient) {
        return (root, query, cb) -> {
            if (hasNotIngredient == null) {
                return null;
            }
            return cb.notEqual(root.get("ingredients").get("id"), hasNotIngredient);
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
