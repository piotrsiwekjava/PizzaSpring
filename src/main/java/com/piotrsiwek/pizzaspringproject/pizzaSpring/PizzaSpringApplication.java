package com.piotrsiwek.pizzaspringproject.pizzaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzaSpringApplication {

	public static void main(String[] args) {

//		Ingredient i = new Ingredient(2,"sasd", Ingredient.Type.SAUCE);
//		System.out.println("1 _" + i);
//		System.out.println("1 _" + i.toString());
//		System.out.println(Ingredient.Type.SAUCE.toString());

		SpringApplication.run(PizzaSpringApplication.class, args);
	}

}
