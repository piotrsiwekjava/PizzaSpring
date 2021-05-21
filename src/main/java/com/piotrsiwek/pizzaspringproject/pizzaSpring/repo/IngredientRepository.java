package com.piotrsiwek.pizzaspringproject.pizzaSpring.repo;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;


public interface IngredientRepository 
         extends CrudRepository<Ingredient, Integer> {

}
