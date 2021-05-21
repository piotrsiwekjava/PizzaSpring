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
  @Size(min=3, message="Musisz wybrać chociaż jeden składnik")
  private List<Ingredient> ingredients = new ArrayList<>();
  
  @PrePersist
  void createdAt() {
    this.createdAt = new Date();
  }
}
