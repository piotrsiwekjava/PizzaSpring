package com.piotrsiwek.pizzaspringproject.pizzaSpring.repo;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IngredientRepository 
         extends CrudRepository<Ingredient, Integer> {

    public List<Ingredient> findByType(Ingredient.Type type);
}
