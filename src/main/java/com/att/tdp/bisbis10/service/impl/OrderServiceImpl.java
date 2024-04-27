package com.att.tdp.bisbis10.service.impl;

import com.att.tdp.bisbis10.model.Order;
import com.att.tdp.bisbis10.repository.OrderRepository;
import com.att.tdp.bisbis10.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{
    OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public String createOrder(Order order) {
        orderRepository.save(order);
        return order.getId().toString();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
