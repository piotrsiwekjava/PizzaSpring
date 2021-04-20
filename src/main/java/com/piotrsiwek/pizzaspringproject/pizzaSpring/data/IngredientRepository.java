package com.piotrsiwek.pizzaspringproject.pizzaSpring.data;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.Ingredient;
import org.springframework.data.repository.CrudRepository;


public interface IngredientRepository 
         extends CrudRepository<Ingredient, String> {

}
