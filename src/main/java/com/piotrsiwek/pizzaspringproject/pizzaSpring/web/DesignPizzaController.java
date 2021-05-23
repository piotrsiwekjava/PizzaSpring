package com.piotrsiwek.pizzaspringproject.pizzaSpring.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Ingredient;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Ingredient.Type;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Order;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Pizza;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.repo.IngredientRepository;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignPizzaController {

  private final IngredientRepository ingredientRepo;

  private PizzaRepository pizzaRepo;


  @Autowired
  public DesignPizzaController(
        IngredientRepository ingredientRepo,
        PizzaRepository pizzaRepo) {
    this.ingredientRepo = ingredientRepo;
    this.pizzaRepo = pizzaRepo;
  }

  @ModelAttribute(name = "order")
  public Order order() {
    return new Order();
  }

  @ModelAttribute(name = "newPizza")
  public Pizza newPizza() {
    return new Pizza();
  }


  @GetMapping
  public String showDesignForm(Model model) {
    List<Ingredient> ingredients = new ArrayList<>();
    ingredientRepo.findAll().forEach(i -> ingredients.add(i));

    Type[] types = Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(),
          filterByType(ingredients, type));
    }

    return "design";
  }

  @PostMapping
  public String processDesign(
      @Valid Pizza pizza, Errors errors,
      @ModelAttribute Order order) {

    if (errors.hasErrors()) {
      return "redirect:/design";
    }
    Pizza saved = pizzaRepo.save(pizza);
    order.addDesign(saved);

    return "redirect:/orders/current";
  }


  private List<Ingredient> filterByType(
      List<Ingredient> ingredients, Type type) {
    return ingredients
              .stream()
              .filter(x -> x.getType().equals(type))
              .collect(Collectors.toList());
  }
}
