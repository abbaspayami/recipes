package com.amro.recipes.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
@Data
@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tile", length = 50)
    private String title;

    @Column(name = "serve", nullable = false)
    private Integer serve;

    // TODO: Full text search index should be created for this field (Look at MySQL and Hibernate docs)
    @Column(name = "instructions")
    private String instructions;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_foodType_id", referencedColumnName = "id")
    private FoodType rfFoodType;

}
