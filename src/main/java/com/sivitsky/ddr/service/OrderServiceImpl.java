package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.OrderDAO;
import com.sivitsky.ddr.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    @Transactional
    public Order saveOrder(Order order) {
        return orderDAO.saveOrder(order);
    }

    @Transactional
    public List<Order> listOrder() {
        return orderDAO.listOrder();
    }

    @Transactional
    public void removeOrder(Long id) {
        orderDAO.removeOrder(id);
    }

    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Transactional
    public Order getOrderById(Long id) {
        return this.orderDAO.getOrderById(id);
    }

}
