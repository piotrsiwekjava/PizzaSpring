package com.piotrsiwek.pizzaspringproject.pizzaSpring.repo;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Order;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository 
         extends CrudRepository<Order, Long> {

    List<Order> findByUserOrderByPlacedAtDesc(
            User user, Pageable pageable);

}
