package com.piotrsiwek.pizzaspringproject.pizzaSpring.repo;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository
         extends CrudRepository<Pizza, Long> {

}
