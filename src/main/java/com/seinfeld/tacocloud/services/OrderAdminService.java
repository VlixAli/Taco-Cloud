package com.seinfeld.tacocloud.services;

import com.seinfeld.tacocloud.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderAdminService {

    private OrderRepository orderRepository;

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders(){
        orderRepository.deleteAll();
    }
}
