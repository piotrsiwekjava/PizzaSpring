// tag::allButDetailProperties[]
package com.piotrsiwek.pizzaspringproject.pizzaSpring;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
@Entity
@Table(name="Taco_Order")
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  private Date placedAt;
  
//end::allButDetailProperties[]
  @NotBlank(message="Musisz podać swoje imię!")
  private String deliveryName;
  
  @NotBlank(message="Ulica jest wymagana!")
  private String deliveryStreet;
  
  @NotBlank(message="Miasto jest wymagane!")
  private String deliveryCity;

  @NotBlank(message="Kod pocztowy jest wymagany!")
  private String deliveryZip;

  @CreditCardNumber(message="Nie prawidłowy numer karty kredytowej!")
  private String ccNumber;
  
  @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
           message="Must be formatted MM/YY")
  private String ccExpiration;

  @Digits(integer=3, fraction=0, message="Niewłaściwy CVV")
  private String ccCVV;

  /*
  //tag::allButDetailProperties[]
  ...
  
  //end::allButDetailProperties[]
   */
  
//tag::allButDetailProperties[]
  @ManyToMany(targetEntity= Pizza.class)
  private List<Pizza> tacos = new ArrayList<>();
  
  public void addDesign(Pizza design) {
    this.tacos.add(design);
  }
  
  @PrePersist
  void placedAt() {
    this.placedAt = new Date();
  }
  
}
//end::allButDetailProperties[]
