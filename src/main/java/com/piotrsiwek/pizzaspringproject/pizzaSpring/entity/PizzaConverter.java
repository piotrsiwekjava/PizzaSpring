package com.piotrsiwek.pizzaspringproject.pizzaSpring.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Data
public class PizzaConverter{


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=3, message="Za krótka nazwa. Podaj taką aby kucharz zrozumiał.")
    @NotBlank(message="Musisz podać nazwe pizzy.")
    private String name;

    private Date createdAt;

    @ManyToMany(targetEntity=Ingredient.class)
    @JoinColumn(name = "pizza_id")
    private List<Ingredient> ingredients = new ArrayList<>();

    private double price;
    @NotNull(message = "Wybierz rozmiar")
    private Ingredient size;

    @NotNull
    private Ingredient base;
    private Ingredient cheese;
    private Ingredient sauces;
//
//    public PizzaConverter() {
//    }
//
//    public PizzaConverter(Long id, @NotNull @Size(min = 3, message = "Za krótka nazwa. Podaj taką aby kucharz zrozumiał.") @NotBlank(message = "Musisz podać nazwe pizzy.") String name, Date createdAt, List<Ingredient> ingredients, double price, @NotNull(message = "Wybierz rozmiar") Ingredient size, @NotNull Ingredient base, Ingredient cheese, Ingredient sauces) {
//        this.id = id;
//        this.name = name;
//        this.createdAt = createdAt;
//        this.ingredients = ingredients;
//        this.price = price;
//        this.size = size;
//        this.base = base;
//        this.cheese = cheese;
//        this.sauces = sauces;
//    }

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    public Pizza convert() {
        Pizza newPizzaConverted = new Pizza(this.id,this.name,this.createdAt,this.ingredients);
        newPizzaConverted.addIngredient(size);
        newPizzaConverted.addIngredient(base);
        newPizzaConverted.addIngredient(cheese);
        newPizzaConverted.addIngredient(sauces);
        newPizzaConverted.getIngredients().sort(Comparator.comparing(Ingredient::getType));
        newPizzaConverted.calculateThePizzaValue();
        return newPizzaConverted;
    }
}
