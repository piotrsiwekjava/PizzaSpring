package com.piotrsiwek.pizzaspringproject.pizzaSpring;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Ingredient;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.repo.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class PizzaSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(PizzaSpringApplication.class, args);
	}



}
