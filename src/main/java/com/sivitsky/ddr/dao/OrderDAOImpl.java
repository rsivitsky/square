package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Offer;
import com.sivitsky.ddr.model.Order;
import com.sivitsky.ddr.model.OrderStatus;
import com.sivitsky.ddr.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);
    private SessionFactory sessionFactory;

    @Autowired(required=true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Order saveOrder(Order order) {
        sessionFactory.getCurrentSession().saveOrUpdate(order);
        logger.info("Order updated successfully, Order id=" + order.getOrder_id());
        return order;
    }

    @SuppressWarnings("unchecked")
    public List<Order> listOrder() {
        return sessionFactory.getCurrentSession().createQuery("from Order").list();
    }

    public Order getOrderById(Long id) {
        return (Order) this.sessionFactory.getCurrentSession().get(Order.class, id);
    }

    public void removeOrder(Long id) {
        Order order = (Order) sessionFactory.getCurrentSession().load(Order.class, id);
        if (null != order) {
            sessionFactory.getCurrentSession().delete(order);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Order> listOrderByUserId(Long user_id){
        String[] booking_status = {OrderStatus.NEW.toString(), OrderStatus.PAID.toString()};
        return sessionFactory.getCurrentSession().getNamedQuery("Order.getOrdersByUserId")
                .setParameter("user", user_id)
                .setParameter("booking_status", booking_status)
                .list();
    }

    @SuppressWarnings("unchecked")
    public Object getOrderTotalByUserId(Long user_id, String[] booking_status){
        return sessionFactory.getCurrentSession().getNamedQuery("Order.getCountAndSumOrdersByUserId")
                .setParameter("user_id", user_id)
                .uniqueResult();
    }
}
