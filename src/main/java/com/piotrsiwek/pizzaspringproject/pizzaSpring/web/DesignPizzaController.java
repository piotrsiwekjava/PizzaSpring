package com.piotrsiwek.pizzaspringproject.pizzaSpring.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Ingredient;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Ingredient.Type;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Order;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.Pizza;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.classes.PizzaConverter;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.entity.User;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.repo.IngredientRepository;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.repo.PizzaRepository;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.repo.UserRepository;
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

  private UserRepository userRepo;


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

  @ModelAttribute("pizzaConverter")
  public PizzaConverter pizzaConverter() {
    return new PizzaConverter();
  }

  @ModelAttribute("ingredientsList")
  public List<List<Ingredient>> ingredientsList(){
    return giveIngredientsList();
  }

  @ModelAttribute("user")
  public User user(Principal principal){
    String userName = principal.getName();
    return userRepo.findByUsername(userName);
  }

  @GetMapping
  public String showDesignForm(Model model, Principal principal) {

    return "design";
  }

  @PostMapping
  public String processDesign(
      @Valid @ModelAttribute("pizzaConverter") PizzaConverter pizzaConverter, Errors errors,
      @ModelAttribute Order order) {


    if (errors.hasErrors()) {
      return "design";
    }
    Pizza pizza = pizzaConverter.convert();
    Pizza saved = pizzaRepo.save(pizza);
    order.addNewPizza(saved);

    return "redirect:/orders/current";
  }


  private List<Ingredient> filterByType(
      List<Ingredient> ingredients, Type type) {
    return ingredients
              .stream()
              .filter(x -> x.getType().equals(type))
              .collect(Collectors.toList());
  }
  private List<List<Ingredient>> giveIngredientsList(){
    List<List<Ingredient>> ingredients = new ArrayList<>();
    Ingredient.Type[] types = Ingredient.Type.values();
    for (Ingredient.Type type : types) {
      ingredients.add(giveSortedIngredientListByType(type));
    }
    return ingredients;
  }

  private List<Ingredient> giveSortedIngredientListByType (Type type){
    List<Ingredient> sortedList = new ArrayList<>();
    ingredientRepo.findByType(type).forEach(i -> sortedList.add(i));
    return sortByPriceAndName(sortedList);
  }

  private List<Ingredient> sortByPriceAndName(List<Ingredient> ingredients) {
    List<Ingredient> sortedIngredient = ingredients.stream()
            .sorted(Comparator
                    .comparing(Ingredient::getPrice)
                    .thenComparing(Ingredient::getName))
            .collect(Collectors.toList());
    return sortedIngredient;
  }

}
