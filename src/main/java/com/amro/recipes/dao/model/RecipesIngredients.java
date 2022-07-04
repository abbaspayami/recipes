package com.amro.recipes.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "recipes_Ingredients")
@NoArgsConstructor
@Data
public class RecipesIngredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private Float amount;

    @Column(nullable = false)
    @OneToMany(targetEntity = Recipes.class, mappedBy = "rfRecipeIngredients", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ingredients> ingredients;

    @Column(nullable = false)
    @OneToMany(targetEntity = Recipes.class, mappedBy = "rfRecipeIngredients", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Recipes> recipes;

}
