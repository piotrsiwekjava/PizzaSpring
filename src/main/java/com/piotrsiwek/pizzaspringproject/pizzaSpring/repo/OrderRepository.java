package com.piotrsiwek.pizzaspringproject.pizzaSpring.repo;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository 
         extends CrudRepository<Order, Long> {

}
