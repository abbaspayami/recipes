package com.amro.recipes.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ingredient", length = 50, nullable = false, unique = true)
    private String ingredient;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit", length = 50)
    private IngredientUnit unit;

}
