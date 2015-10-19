package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Order;

import java.util.List;

public interface OrderService {

    public void addOrder(Order order);

    public List<Order> listOrder();

    public void removeOrder(Integer id);

}
