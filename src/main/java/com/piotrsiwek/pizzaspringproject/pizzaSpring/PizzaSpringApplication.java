package com.piotrsiwek.pizzaspringproject.pizzaSpring;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Ingredient;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.repo.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PizzaSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(PizzaSpringApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner dataLoader(IngredientRepository repo) {
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				repo.save(new Ingredient(1, "Cienkie ciasto", Ingredient.Type.BASE, 10.0));
//				repo.save(new Ingredient(2, "Grube ciasto", Ingredient.Type.BASE, 15.0));
//
//				repo.save(new Ingredient(3, "Gouda", Ingredient.Type.CHEESE, 0.0));
//				repo.save(new Ingredient(4, "Mozzarella", Ingredient.Type.CHEESE, 0.0));
//
//				repo.save(new Ingredient(5, "Pomidorowy", Ingredient.Type.SAUCE, 0.0));
//				repo.save(new Ingredient(6, "Czosnkowy", Ingredient.Type.SAUCE, 0.0));
//
//				repo.save(new Ingredient(7, "Salami", Ingredient.Type.TOPPINGS, 5.0));
//				repo.save(new Ingredient(8, "Jalapeno", Ingredient.Type.TOPPINGS, 5.0));
//				repo.save(new Ingredient(9, "Papryka", Ingredient.Type.TOPPINGS, 5.0));
//				repo.save(new Ingredient(10, "Pieczarki", Ingredient.Type.TOPPINGS, 5.0));
//			}
//		};
//	}

}
