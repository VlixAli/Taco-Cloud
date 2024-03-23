package com.seinfeld.tacocloud.controllers;

import com.seinfeld.tacocloud.services.OrderAdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private OrderAdminService orderAdminService;

    @PostMapping("/deleteOrders")
    public String deleteAllOrders(){
        orderAdminService.deleteAllOrders();
        return "redirect:/admin";
    }
}
