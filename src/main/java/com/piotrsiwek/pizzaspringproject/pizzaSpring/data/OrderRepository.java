package com.piotrsiwek.pizzaspringproject.pizzaSpring.data;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository 
         extends CrudRepository<Order, Long> {

}
