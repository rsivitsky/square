package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Order;
import com.sivitsky.ddr.model.User;

import java.util.List;

public interface OrderDAO {

    List<Order> listOrder();

    Order saveOrder(Order order);

    Order getOrderById(Long id);

    void removeOrder(Long id);

    List<Order> listOrderByUserId(Long id);

}
