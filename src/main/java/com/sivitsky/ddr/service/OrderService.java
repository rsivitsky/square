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

    List<Order> getOrdersByUserId(Long user_id);

    List<Order> getOrdersByVendorId(Long vendor_id);

    void cancelOrder(Long order_id);

}
