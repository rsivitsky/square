package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Order;
import com.sivitsky.ddr.model.User;

import java.util.List;

public interface OrderService {

    Order saveOrder(Order order);

    List<Order> listOrder();

    void removeOrder(Long id);

    Order getOrderById(Long id);

    Object getOrderTotalByUserId(Long user, String[] status);

}
