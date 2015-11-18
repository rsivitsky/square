package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Phone;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneDAOImpl implements PhoneDAO {

    private static final Logger logger = LoggerFactory.getLogger(PhoneDAOImpl.class);
    private SessionFactory sessionFactory;

    public Phone savePhone(Phone phone) {
        sessionFactory.getCurrentSession().saveOrUpdate(phone);
        logger.info("Phone updated successfully, Phone id=" + phone.getPhone_id());
        return phone;
    }

    @SuppressWarnings("unchecked")
    public List<Phone> listPhones() {
        return sessionFactory.getCurrentSession().createQuery("from Phone").list();
    }

    public Phone getPhoneById(Long id) {
        return (Phone) this.sessionFactory.getCurrentSession().get(Phone.class, id);
    }

    public void removePhone(Long id) {
        Phone phone = (Phone) sessionFactory.getCurrentSession().load(Phone.class, id);
        if (null != phone) {
            sessionFactory.getCurrentSession().delete(phone);
        }
    }

    @Autowired(required=true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
