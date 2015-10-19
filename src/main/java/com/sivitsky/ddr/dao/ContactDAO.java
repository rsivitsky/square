package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Contact;

import java.util.List;

public interface ContactDAO {

    public void addContact(Contact contact);

    public List<Contact> listContact();

    public void removeContact(Integer id);

    public void updateContact(Contact contact);

    public Contact getContactById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);

}
