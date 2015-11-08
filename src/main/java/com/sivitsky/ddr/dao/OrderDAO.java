package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Order;

import java.util.List;

public interface OrderDAO {

    List<Order> listOrder();

    Order saveOrder(Order Order);

    Order getOrderById(Long id);

    void removeOrder(Long id);

}
