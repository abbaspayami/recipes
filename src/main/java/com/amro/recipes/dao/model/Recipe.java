package com.amro.recipes.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
@Data
@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 50, nullable = false, unique = true)
    private String title;

    @Column(name = "serve", nullable = false)
    private Integer serve;

    @Column(name = "instructions", length = 300, nullable = false)
    private String instructions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_foodType_id", referencedColumnName = "id")
    private FoodType rfFoodType;

}
