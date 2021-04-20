package com.piotrsiwek.pizzaspringproject.pizzaSpring;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
//@RequiredArgsConstructor
//@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Ingredient {
  
  @Id
  private String id;
  private String name;
  private Type type;
//  private final String id;
//  private final String name;
//  private final Type type;

  public Ingredient() {

  }

  public Ingredient(String id, String name, Type type) {
    this.id = id;
    this.name = name;
    this.type = type;
  }


  public static enum Type {
    BASE, TOPPINGS, CHEESE, SAUCE
  }

  public Type getType() {
    return type;
  }
}
