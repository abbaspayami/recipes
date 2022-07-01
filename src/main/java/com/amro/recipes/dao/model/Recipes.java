package com.amro.recipes.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "recipes")
@Getter
@Setter
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipes_Id")
    private Integer id;

}
