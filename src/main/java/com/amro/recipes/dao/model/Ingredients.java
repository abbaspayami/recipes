package com.amro.recipes.dao.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
@NoArgsConstructor
@Data
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_recipeIngredients_id", referencedColumnName = "id")
    private RecipesIngredients recipeIngredients;

}
