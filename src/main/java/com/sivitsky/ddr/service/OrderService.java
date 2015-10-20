package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Order;

import java.util.List;

public interface OrderService {

    void addOrder(Order order);

    List<Order> listOrder();

    void removeOrder(Integer id);

}
