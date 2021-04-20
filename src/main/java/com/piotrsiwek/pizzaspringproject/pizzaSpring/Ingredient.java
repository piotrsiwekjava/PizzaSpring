package com.piotrsiwek.pizzaspringproject.pizzaSpring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Table(name = "ingredient")
//@RequiredArgsConstructor
//@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Ingredient {
  
  @Id
  @GeneratedValue(generator = "inc")
  @GenericGenerator(name = "inc", strategy = "increment")
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
