package com.att.tdp.bisbis10.service;


import com.att.tdp.bisbis10.model.Order;

import java.util.List;

public interface OrderService {

    public String createOrder(Order order);
    public List<Order> getAllOrders();
}
