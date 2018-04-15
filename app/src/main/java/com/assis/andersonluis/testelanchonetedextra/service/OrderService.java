package com.assis.andersonluis.testelanchonetedextra.service;

import com.assis.andersonluis.testelanchonetedextra.model.Order;

import java.util.List;

public interface OrderService  {

    void getOrders(BaseRequestCallback<List<Order>, RuntimeException> callback);
    void createOrder(Order order, BaseRequestCallback<Order, RuntimeException> callback);
}
