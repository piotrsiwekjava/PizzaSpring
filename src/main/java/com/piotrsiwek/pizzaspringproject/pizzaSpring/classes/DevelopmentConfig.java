package com.piotrsiwek.pizzaspringproject.pizzaSpring.classes;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Ingredient;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.User;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.repo.IngredientRepository;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.repo.PizzaRepository;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Profile("!prod")
@Configuration
public class DevelopmentConfig {

  private IngredientRepository ingredientRepository;
  private PizzaRepository pizzaRepository;

  @Autowired
  public DevelopmentConfig(IngredientRepository ingredientRepository, PizzaRepository pizzaRepository) {
    this.ingredientRepository = ingredientRepository;
    this.pizzaRepository = pizzaRepository;

    Ingredient s1 = new Ingredient(101, "Mała", Ingredient.Type.SIZE, 15.0);
    Ingredient s2 = new Ingredient(102, "Normalna", Ingredient.Type.SIZE, 20.0);
    Ingredient s3 = new Ingredient(103, "Duża", Ingredient.Type.SIZE, 30.0);
    Ingredient s4 = new Ingredient(104, "XXL", Ingredient.Type.SIZE, 40.0);

    Ingredient i1 = new Ingredient(121, "Cienkie ciasto", Ingredient.Type.BASE, 0.0);
    Ingredient i2 = new Ingredient(122, "Grube ciasto", Ingredient.Type.BASE, 10.0);

    Ingredient i3 = new Ingredient(1, "Ser Gouda", Ingredient.Type.CHEESE, 0.0);
    Ingredient i4 = new Ingredient(2, "Ser Mozzarella", Ingredient.Type.CHEESE, 0.0);


    Ingredient i5 = new Ingredient(51, "Sos Pomidorowy", Ingredient.Type.SAUCE, 0.0);
    Ingredient i6 = new Ingredient(52, "Sos Czosnkowy", Ingredient.Type.SAUCE, 0.0);


    Ingredient t1 = new Ingredient(201, "salami", Ingredient.Type.MEAT, 5.0);
    Ingredient t2 = new Ingredient(202, "jalapeno", Ingredient.Type.VEGE, 5.0);
    Ingredient t3 = new Ingredient(203, "papryka", Ingredient.Type.VEGE, 5.0);
    Ingredient t4 = new Ingredient(204, "pieczarki", Ingredient.Type.VEGE, 5.0);
    Ingredient t5 = new Ingredient(205, "mięso wołowo-drobiowe", Ingredient.Type.MEAT, 5.0);
    Ingredient t6 = new Ingredient(206, "boczek", Ingredient.Type.MEAT, 5.0);
    Ingredient t7 = new Ingredient(207, "cebula", Ingredient.Type.VEGE, 5.0);
    Ingredient t8 = new Ingredient(208, "kiełbasa", Ingredient.Type.MEAT, 5.0);
    Ingredient t9 = new Ingredient(209, "kurczak gyros", Ingredient.Type.MEAT, 5.0);
    Ingredient t10 = new Ingredient(210, "ananas", Ingredient.Type.VEGE, 5.0);


    ingredientRepository.save(s1);
    ingredientRepository.save(s2);
    ingredientRepository.save(s3);
    ingredientRepository.save(s4);

    ingredientRepository.save(i1);
    ingredientRepository.save(i2);
    ingredientRepository.save(i3);
    ingredientRepository.save(i4);
    ingredientRepository.save(i5);
    ingredientRepository.save(i6);

    ingredientRepository.save(t1);
    ingredientRepository.save(t2);
    ingredientRepository.save(t3);
    ingredientRepository.save(t4);
    ingredientRepository.save(t5);
    ingredientRepository.save(t6);
    ingredientRepository.save(t7);
    ingredientRepository.save(t8);
    ingredientRepository.save(t9);
    ingredientRepository.save(t10);

  }

  @Bean
  public CommandLineRunner dataLoader(IngredientRepository repo,
                                      UserRepository userRepo, PasswordEncoder encoder) {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        userRepo.save(new User("Mała Księżniczka", encoder.encode("password"),
                "Eliza Orzeszkowa", "12/2 Nad Niemnem", "Polskie Miasto",
                "01-001", "700-880-774"));
      }
    };
  }


}
