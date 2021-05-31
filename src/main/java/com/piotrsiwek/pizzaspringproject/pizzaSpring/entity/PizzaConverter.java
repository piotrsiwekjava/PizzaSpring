package com.piotrsiwek.pizzaspringproject.pizzaSpring.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Data
public class PizzaConverter extends Pizza{


    @NotNull(message = "Wybierz rozmiar")
    private Ingredient size;

    @NotNull
    private Ingredient base;
    private Ingredient cheese;
    private Ingredient sauces;



    public PizzaConverter() {
    }

    public PizzaConverter(Long id, String name, Date createdAt, List<Ingredient> ingredients, Ingredient size, Ingredient base, Ingredient cheese, Ingredient sauces) {
        super(id, name, createdAt, ingredients);
        this.size = size;
        this.base = base;
        this.cheese = cheese;
        this.sauces = sauces;
    }


    public Pizza convert() {
        Pizza newPizzaConverted = new Pizza(this.getId(),this.getName(),this.getCreatedAt(),this.getIngredients());
        newPizzaConverted.addIngredient(size);
        newPizzaConverted.addIngredient(base);
        newPizzaConverted.addIngredient(cheese);
        newPizzaConverted.addIngredient(sauces);
        newPizzaConverted.getIngredients().sort(Comparator.comparing(Ingredient::getType));
        newPizzaConverted.calculateThePizzaValue();
        return newPizzaConverted;
    }
}
