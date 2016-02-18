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

    Object getOrderTotalByUserId(Long user_id, String[] status);

    List<Order> getOrdersByUserId(Long user_id);

    List<Order> getOrdersByVendorId(Long vendor_id);

    void cancelOrder(Long order_id);

}
