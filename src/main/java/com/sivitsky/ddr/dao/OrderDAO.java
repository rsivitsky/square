package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Order;

import java.util.List;

public interface OrderDAO {

    void addOrder(Order order);

    List<Order> listOrder();

    void removeOrder(Integer id);

    void updateOrder(Order order);

    Order getOrderById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);

}
