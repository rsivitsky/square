package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//@Repository
public class ContactDAOImpl implements ContactDAO {


    private static final Logger logger = LoggerFactory.getLogger(ContactDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> listContact() {

        return sessionFactory.getCurrentSession().createQuery("from Contact")
                .list();
    }

    @Override
    public void removeContact(Integer id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(
                Contact.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }

    }

    @Override
    public Contact getContactById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Contact contact = (Contact) session.load(Contact.class, new Integer(id));
        logger.info("Contact loaded successfully, User details="+contact);
        return contact;
    }

    @Override
    public void updateContact(Contact contact) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(contact);
        logger.info("Contact updated successfully, Contact Details="+contact);
    }

}
