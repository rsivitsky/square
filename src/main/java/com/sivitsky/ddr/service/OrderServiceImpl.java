package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.OrderDAO;
import com.sivitsky.ddr.model.Order;
import com.sivitsky.ddr.model.User;
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

    @Transactional
         public Object getOrderTotalByUserId(Long user, String[] status){
        return this.orderDAO.getOrderTotalByUserId(user, status);
    }

    @Transactional
    public  List<Order> getOrdersByUserId(Long user_id){
        return this.orderDAO.getOrdersByUserId(user_id);
    }

    @Transactional
    public  List<Order> getOrdersByVendorId(Long vendor_id){
        return this.orderDAO.getOrdersByVendorId(vendor_id);
    }

    @Transactional
    public  void cancelOrder(Long order_id){
        this.orderDAO.cancelOrder(order_id);
    }
}
