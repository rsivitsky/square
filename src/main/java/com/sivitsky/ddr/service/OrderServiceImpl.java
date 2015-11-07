package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.OrderDAO;
import com.sivitsky.ddr.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Transactional
    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    @Transactional
    public List<Order> listOrder() {

        return orderDAO.listOrder();
    }

    @Transactional
    public void removeOrder(Integer id) {
        orderDAO.removeOrder(id);
    }

}