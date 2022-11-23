package com.amro.recipes.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
@Data
@Entity
@Table(name = "recipe")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "instructions", length = 300, nullable = false)
    private String instructions;

//    @Column(name = "default_serving_number")
//    private String defaultServingNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_food_type_id", referencedColumnName = "id")
    private FoodType foodTypeId;

}
