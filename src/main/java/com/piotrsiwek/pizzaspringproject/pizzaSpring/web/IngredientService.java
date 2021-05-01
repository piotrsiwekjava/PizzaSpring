package com.piotrsiwek.pizzaspringproject.pizzaSpring.web;

import java.util.Optional;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.Ingredient;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
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
