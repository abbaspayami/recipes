package com.amro.recipes.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "recipe_Ingredient")
@NoArgsConstructor
@Data
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_ingredient_id", referencedColumnName = "id")
    private Ingredient rfIngredients;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_recipe_id", referencedColumnName = "id")
    private Recipe rfRecipes;

}
