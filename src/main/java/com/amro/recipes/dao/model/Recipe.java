package com.amro.recipes.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tile", length = 50)
    private String title;

    @Column(name = "serve", nullable = false)
    private Integer serve = 1;

    // TODO: Full text search index should be created for this field (Look at MySQL and Hibernate docs)
    @Column(name = "instructions")
    private String instructions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_foodCategories_id", referencedColumnName = "id")
    private FoodType rfFoodType;

    @JoinTable
    @OneToMany
    private List<Ingredient> ingredients;


}
