package com.piotrsiwek.pizzaspringproject.pizzaSpring;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Ingredient;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Pizza;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.repo.IngredientRepository;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Start {

    private IngredientRepository ingredientRepository;
    private PizzaRepository pizzaRepository;

    @Autowired
    public Start(IngredientRepository ingredientRepository, PizzaRepository pizzaRepository){
        this.ingredientRepository=ingredientRepository;
        this.pizzaRepository=pizzaRepository;

        System.out.println("dodawanie składników");

        Ingredient i1 = new Ingredient(1, "Cienkie ciasto", Ingredient.Type.BASE, 10.0);
        Ingredient i2 = new Ingredient(2, "Grube ciasto", Ingredient.Type.BASE, 15.0);
        Ingredient i3 = new Ingredient(3, "Gouda", Ingredient.Type.CHEESE, 0.0);
        Ingredient i4 = new Ingredient(4, "Mozzarella", Ingredient.Type.CHEESE, 0.0);
        Ingredient i5 = new Ingredient(5, "Pomidorowy", Ingredient.Type.SAUCE, 0.0);
        Ingredient i6 = new Ingredient(6, "Czosnkowy", Ingredient.Type.SAUCE, 0.0);
        Ingredient i7 = new Ingredient(7, "Salami", Ingredient.Type.TOPPINGS, 5.0);
        Ingredient i8 = new Ingredient(8, "Jalapeno", Ingredient.Type.TOPPINGS, 5.0);
        Ingredient i9 = new Ingredient(9, "Papryka", Ingredient.Type.TOPPINGS, 5.0);
        Ingredient i10 = new Ingredient(10, "Pieczarki", Ingredient.Type.TOPPINGS, 5.0);

        List<Ingredient> ingredients1 = new ArrayList<>();
        ingredients1.add(i1);
        ingredients1.add(i3);
        ingredients1.add(i5);
        ingredients1.add(i7);
        List<Ingredient> ingredients2 = new ArrayList<>();
        ingredients2.add(i2);
        ingredients2.add(i4);
        ingredients2.add(i5);
        ingredients2.add(i9);
        ingredients2.add(i10);

        System.out.println("Balanga  " + i1);

//        Pizza p1 = new Pizza(1,"vege z papryka",ingredients1);
//        Pizza p2 = new Pizza(2,"salami na grubym cieście",ingredients2);

//        System.out.println(p1);

    }

//
//    insert into pizzaIngredients (id_pizza, id_ingredient) values (1,1);
//    insert into pizzaIngredients (id_pizza, id_ingredient) values (1,3);
//    insert into pizzaIngredients (id_pizza, id_ingredient) values (1,5);
//    insert into pizzaIngredients (id_pizza, id_ingredient) values (1,7);
//
//    insert into pizzaIngredients (id_pizza, id_ingredient) values (2,2);
//    insert into pizzaIngredients (id_pizza, id_ingredient) values (2,4);
//    insert into pizzaIngredients (id_pizza, id_ingredient) values (2,5);
//    insert into pizzaIngredients (id_pizza, id_ingredient) values (2,9);
//    insert into pizzaIngredients (id_pizza, id_ingredient) values (2,10);
}
