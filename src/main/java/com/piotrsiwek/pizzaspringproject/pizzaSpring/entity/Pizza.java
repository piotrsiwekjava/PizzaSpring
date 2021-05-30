package com.piotrsiwek.pizzaspringproject.pizzaSpring.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity

public class Pizza {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @NotNull
  @Size(min=5, message="Za krótka nazwa. Podaj taką aby kucharz zrozumiał.")
  private String name;

  private Date createdAt;

  @ManyToMany(targetEntity=Ingredient.class)
  @JoinColumn(name = "pizza_id")
  @Size(min=3, message="Musisz wybrać chociaż jeden składnik")
  private List<Ingredient> ingredients = new ArrayList<>();

  private double price;

  public Pizza() {
  }

  public Pizza(Long id, String name, Date createdAt, List<Ingredient> ingredients) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.ingredients = ingredients;
  }

  @PrePersist
  void createdAt() {
    this.createdAt = new Date();
  }

  public void addIngredient (Ingredient in){
    ingredients.add(in);
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public double calculateThePizzaValue(){
    double inc=1;
    for (Ingredient ingredient: ingredients){
      if (ingredient.getType()== Ingredient.Type.SIZE)
        inc=ingredient.getPrice();
      else if (ingredient.getType()== Ingredient.Type.BASE)
        price +=(((100+ingredient.getPrice())/100)*inc);
      else price+=ingredient.getPrice();
    }
    return price;
  }
}
