package com.piotrsiwek.pizzaspringproject.pizzaSpring;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.data.IngredientRepository;
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
//				repo.save(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.BASE));
//				repo.save(new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.BASE));
//				repo.save(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.TOPPINGS));
//				repo.save(new Ingredient("CARN", "Carnitas", Ingredient.Type.TOPPINGS));
//				repo.save(new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.TOPPINGS));
//				repo.save(new Ingredient("LETC", "Lettuce", Ingredient.Type.TOPPINGS));
//				repo.save(new Ingredient("CHED", "Cheddar",Ingredient.Type.CHEESE));
//				repo.save(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
//				repo.save(new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
//				repo.save(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
//			}
//		};
//	}

}
