package com.amro.recipes.dao.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Food_Categories")
@NoArgsConstructor
@Data
public class FoodCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String foodType;

    @Column(nullable = false)
    @OneToMany(targetEntity = Recipes.class, mappedBy = "rfFoodCategories", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Recipes> recipes;

}
