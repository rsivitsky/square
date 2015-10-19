package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Order;

import java.util.List;

public interface OrderDAO {

    public void addOrder(Order order);

    public List<Order> listOrder();

    public void removeOrder(Integer id);

    public void updateOrder(Order order);

    public Order getOrderById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);

}
