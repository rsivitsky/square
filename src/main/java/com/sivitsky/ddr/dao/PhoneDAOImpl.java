package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//@Repository
public class PhoneDAOImpl implements PhoneDAO {

    private static final Logger logger = LoggerFactory.getLogger(PhoneDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addPhone(Phone phone) {
        sessionFactory.getCurrentSession().save(phone);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Phone> listPhone() {

        return sessionFactory.getCurrentSession().createQuery("from Phone")
                .list();
    }

    @Override
    public void removePhone(Integer id) {
        Phone phone = (Phone) sessionFactory.getCurrentSession().load(
                Phone.class, id);
        if (null != phone) {
            sessionFactory.getCurrentSession().delete(phone);
        }

    }

    @Override
    public Phone getPhoneById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Phone phone = (Phone) session.load(Phone.class, new Integer(id));
        logger.info("Phone loaded successfully, Phone details="+phone);
        return phone;
    }

    @Override
    public void updatePhone(Phone phone) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(phone);
        logger.info("Phone updated successfully, Phone Details="+phone);
    }

}
