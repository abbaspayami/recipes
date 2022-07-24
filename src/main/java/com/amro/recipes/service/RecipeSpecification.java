package com.amro.recipes.service;

import com.amro.recipes.dao.model.Recipe;
import com.amro.recipes.dto.RecipeSearchDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class RecipeSpecification {

    public Specification<Recipe> search(RecipeSearchDto filter) {
        return Specification.where(serve(filter))
                .and(hasIngredient(filter))
//                .and(hasNotIngredient(filter))
                .and(instruction(filter))
                .and(foodType(filter));
    }

    public Specification<Recipe> hasIngredient(RecipeSearchDto recipeSearchDto) {
        return (root, query, cb) -> {
            if (recipeSearchDto.getHasIngredients() == null || recipeSearchDto.getHasIngredients().isEmpty()) {
                return null;
            }
            return root.get("ingredients").in(recipeSearchDto.getHasIngredients());
        };
    }

    public Specification<Recipe> hasNotIngredient(RecipeSearchDto recipeSearchDto) {
        return (root, query, cb) -> {
            if (recipeSearchDto.getHasNotIngredients() == null || recipeSearchDto.getHasNotIngredients().isEmpty()) {
                return null;
            }
            return cb.not(root.get("ingredients").in(recipeSearchDto.getHasNotIngredients()));
        };
    }

    public Specification<Recipe> serve(RecipeSearchDto recipeSearchDto) {
        return (root, query, cb) -> {
            if (recipeSearchDto.getServe() == null) {
                return null;
            }
            return cb.equal(root.get("serve"), recipeSearchDto.getServe());
        };
    }

    public Specification<Recipe> instruction(RecipeSearchDto recipeSearchDto) {
        return (root, query, cb) -> {
            if (recipeSearchDto.getInstruction() == null) {
                return null;
            }
            return cb.like(cb.lower(root.get("instructions")), "%"+recipeSearchDto.getInstruction()+"%");
        };
    }

    public Specification<Recipe> foodType(RecipeSearchDto recipeSearchDto) {
        return (root, query, cb) -> {
            if (recipeSearchDto.getFoodType() == null) {
                return null;
            }
            return cb.equal(root.get("rfFoodType").get("id"), recipeSearchDto.getFoodType());
        };
    }

}
