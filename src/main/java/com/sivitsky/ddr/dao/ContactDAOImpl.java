package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO {
    
    private static final Logger logger = LoggerFactory.getLogger(ContactDAOImpl.class);
    private SessionFactory sessionFactory;

    @Autowired(required=true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Contact saveContact(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
        logger.info("Contact updated successfully, Contact id=" + contact.getContact_id());
        return contact;
    }

    @SuppressWarnings("unchecked")
    public List<Contact> listContact() {
        return sessionFactory.getCurrentSession().createQuery("from Contact").list();
    }

    public Contact getContactById(Long id) {
        return (Contact) this.sessionFactory.getCurrentSession().get(Contact.class, id);
    }

    public void removeContact(Long id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
    }
}
