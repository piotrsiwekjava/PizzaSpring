package com.piotrsiwek.pizzaspringproject.pizzaSpring;

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


  public static enum Type {
    BASE, TOPPINGS, CHEESE, SAUCE
  }

  public Type getType() {
    return type;
  }
}
