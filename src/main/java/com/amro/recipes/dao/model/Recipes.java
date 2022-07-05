package com.amro.recipes.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "recipes")
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tile", length = 50)
    private String title;

    @Column(name = "serve", nullable = false)
    private Integer serve = 1;

    private String instructions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_foodCategories_id", referencedColumnName = "id")
    private FoodCategories rfFoodCategories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_recipeIngredients_id", referencedColumnName = "id")
    private RecipesIngredients rfRecipeIngredients;


}
