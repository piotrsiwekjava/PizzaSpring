package com.piotrsiwek.pizzaspringproject.pizzaSpring.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.piotrsiwek.pizzaspringproject.pizzaSpring.Ingredient;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.Ingredient.Type;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.Order;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.Pizza;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.data.IngredientRepository;
import com.piotrsiwek.pizzaspringproject.pizzaSpring.data.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


//tag::injectingDesignRepository[]
//tag::injectingIngredientRepository[]
@Controller
@RequestMapping("/design")
//end::injectingIngredientRepository[]
@SessionAttributes("order")
//tag::injectingIngredientRepository[]
public class DesignPizzaController {

  private final IngredientRepository ingredientRepo;

  //end::injectingIngredientRepository[]
  private PizzaRepository tacoRepo;

  //end::injectingDesignRepository[]
  /*
  //tag::injectingIngredientRepository[]
  public DesignTacoController(IngredientRepository ingredientRepo) {
    this.ingredientRepo = ingredientRepo;
  }
  //end::injectingIngredientRepository[]
   */
  //tag::injectingDesignRepository[]

  @Autowired
  public DesignPizzaController(
        IngredientRepository ingredientRepo,
        PizzaRepository tacoRepo) {
    this.ingredientRepo = ingredientRepo;
    this.tacoRepo = tacoRepo;
  }

  @ModelAttribute(name = "order")
  public Order order() {
    return new Order();
  }

  @ModelAttribute(name = "design")
  public Pizza design() {
    return new Pizza();
  }

  //end::injectingDesignRepository[]

  //tag::injectingIngredientRepository[]

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
  //end::injectingIngredientRepository[]

//tag::injectingDesignRepository[]
  @PostMapping
  public String processDesign(
      @Valid Pizza pizza, Errors errors,
      @ModelAttribute Order order) {

    if (errors.hasErrors()) {
      return "design";
    }

    Pizza saved = tacoRepo.save(pizza);
    order.addDesign(saved);

    return "redirect:/orders/current";
  }

//end::injectingDesignRepository[]

  private List<Ingredient> filterByType(
      List<Ingredient> ingredients, Type type) {
    return ingredients
              .stream()
              .filter(x -> x.getType().equals(type))
              .collect(Collectors.toList());
  }

  /*
  //tag::injectingDesignRepository[]
  //tag::injectingIngredientRepository[]

   ...
  //end::injectingIngredientRepository[]
  //end::injectingDesignRepository[]
  */

//tag::injectingDesignRepository[]
//tag::injectingIngredientRepository[]

}
//end::injectingIngredientRepository[]
//end::injectingDesignRepository[]
