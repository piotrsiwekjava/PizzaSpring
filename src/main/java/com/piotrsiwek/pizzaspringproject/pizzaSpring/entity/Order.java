
package com.piotrsiwek.pizzaspringproject.pizzaSpring.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
@Entity
@Table(name="pizza_Order")
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  private Date placedAt;

  @ManyToOne
  private User user;

  @NotBlank()
  private String deliveryName;
  
  @NotBlank()
  private String deliveryStreet;
  
  @NotBlank()
  private String deliveryCity;

  @NotBlank()
  private String deliveryZip;

  @CreditCardNumber()
  private String ccNumber;
  
  @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$")
  private String ccExpiration;

  @Digits(integer=3, fraction=0)
  private String ccCVV;

  @ManyToMany(targetEntity= Pizza.class)
  private List<Pizza> pizzas = new ArrayList<>();
  
  public void addNewPizza(Pizza newPizza) {
    this.pizzas.add(newPizza);
  }
  
  @PrePersist
  void placedAt() {
    this.placedAt = new Date();
  }
  
}
