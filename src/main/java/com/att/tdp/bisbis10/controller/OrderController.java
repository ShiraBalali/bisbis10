package com.att.tdp.bisbis10.controller;


import com.att.tdp.bisbis10.model.Order;
import com.att.tdp.bisbis10.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping
    public Map createOrder(@RequestBody Order order) {
        Map result = new HashMap();
        result.put("orderId", orderService.createOrder(order));

        return result;
    }

    @GetMapping()
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();

    }

}
