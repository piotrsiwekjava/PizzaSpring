package com.piotrsiwek.pizzaspringproject.pizzaSpring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Entity
public class Ingredient {
  
  @Id
  private final Integer id;
  private final String name;
  private final Type type;
  private final Double price;



  public static enum Type {
    SIZE, BASE, CHEESE, SAUCE, VEGE, MEAT
  }

  public Type getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

}
