package com.piotrsiwek.pizzaspringproject.pizzaSpring.classes;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Ingredient;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Pizza;
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
    @Size(min=3, max=25, message="Za krótka nazwa. Minimum 3 znaki, max 25 znaków.")
    @NotBlank(message="Musisz podać nazwe pizzy.")
    private String name;

    private Date createdAt;

    @ManyToMany(targetEntity= Ingredient.class)
    @JoinColumn(name = "pizza_id")
    private List<Ingredient> ingredients = new ArrayList<>();

    private double price;

    @NotNull(message = "Wybierz rozmiar")
    private Ingredient size;

    @NotNull
    private Ingredient base;

    @NotNull
    private Ingredient cheese;

    @NotNull
    private Ingredient sauces;

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
