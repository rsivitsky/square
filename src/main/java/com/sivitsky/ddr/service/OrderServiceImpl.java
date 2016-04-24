package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.OrderDAO;
import com.sivitsky.ddr.model.Cart;
import com.sivitsky.ddr.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
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

    @Transactional
    public Order getOrderById(Long id) {
        return this.orderDAO.getOrderById(id);
    }

    @Transactional
    public Object getOrderTotalByUserId(Long user) {
        return this.orderDAO.getOrderTotalByUserId(user);
    }

    @Transactional
    public List<Order> getOrdersByUserId(Long user_id) {
        return this.orderDAO.getOrdersByUserId(user_id);
    }

    @Transactional
    public List<Order> getOrdersByCart(Cart cart) {
        return this.orderDAO.getOrdersByCart(cart);
    }

    @Transactional
    public List<Order> getOrdersByVendorId(Long vendor_id) {
        return this.orderDAO.getOrdersByVendorId(vendor_id);
    }

    @Transactional
    public void cancelOrder(Long order_id) {
        this.orderDAO.cancelOrder(order_id);
    }
}
