package com.seinfeld.tacocloud.controllers;

import com.seinfeld.tacocloud.models.TacoOrder;
import com.seinfeld.tacocloud.repositories.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()){
            return "orderForm";
        }

        orderRepository.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

    @PostAuthorize("hasRole('ADMIN') || " +
            "returnObject.user.username == authentication.name")
    public TacoOrder getOrder(long id){
        return new TacoOrder();
    }
}
