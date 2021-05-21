package com.piotrsiwek.pizzaspringproject.pizzaSpring.web;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IngredientService {

  private IngredientRepository ingredientRepo;

  @Autowired
  public IngredientService(IngredientRepository ingredientRepo) {
    this.ingredientRepo = ingredientRepo;
  }
  
//  public Ingredient findById(String id){
//    return ingredientRepo
//            .findById(id)
//            .map(Ingredient::new);
//  }

}
