package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//@Repository
public class OrderDAOImpl implements OrderDAO {

    private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> listOrder() {

        return sessionFactory.getCurrentSession().createQuery("from Order")
                .list();
    }

    @Override
    public void removeOrder(Integer id) {
        Order order = (Order) sessionFactory.getCurrentSession().load(
                Order.class, id);
        if (null != order) {
            sessionFactory.getCurrentSession().delete(order);
        }

    }

    @Override
    public Order getOrderById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Order order = (Order) session.load(Order.class, new Integer(id));
        logger.info("Order loaded successfully, Order details="+order);
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(order);
        logger.info("Order updated successfully, Order Details="+order);
    }

}
