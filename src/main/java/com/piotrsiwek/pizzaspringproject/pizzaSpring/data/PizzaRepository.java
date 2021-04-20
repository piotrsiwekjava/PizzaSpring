package com.piotrsiwek.pizzaspringproject.pizzaSpring.data;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository
         extends CrudRepository<Pizza, Long> {

}
