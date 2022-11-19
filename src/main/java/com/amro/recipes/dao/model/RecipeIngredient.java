package com.amro.recipes.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.bind.v2.TODO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
@Data
@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_ingredient_id", referencedColumnName = "id")
    private Ingredient rfIngredients;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_recipe_id", referencedColumnName = "id")
    private Recipe rfRecipes;

//    @Column(name = "amount", nullable = false)
//    private float amount;

//    @Column(name = "serving_number", nullable = false)
//    private Integer servingNumber;

    // TODO: 09/11/2022 create composite index
}


