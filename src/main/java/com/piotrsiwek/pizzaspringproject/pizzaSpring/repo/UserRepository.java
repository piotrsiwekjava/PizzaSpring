package com.piotrsiwek.pizzaspringproject.pizzaSpring.repo;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);
  
}
