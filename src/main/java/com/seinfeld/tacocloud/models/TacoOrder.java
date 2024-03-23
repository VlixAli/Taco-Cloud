package com.seinfeld.tacocloud.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt =new Date();

    @NotBlank(message = "Delivery name is required")
    @Size(max = 50, message = "The state shouldn't be more than 50 characters")
    private String deliveryName;

    @NotBlank(message = "Street is required")
    @Size(max = 50, message = "The state shouldn't be more than 50 characters")
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    @Size(max = 50, message = "The state shouldn't be more than 50 characters")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    @Size(max = 20, message = "The state shouldn't be more than 20 characters")
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    @Size(max = 10, message = "The state shouldn't be more than 10 characters")
    private String deliveryZip;

    @CreditCardNumber(message = "Not  a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[1-9])([2-9][0-9]$)",
            message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0 , message = "Invalid CVV")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
