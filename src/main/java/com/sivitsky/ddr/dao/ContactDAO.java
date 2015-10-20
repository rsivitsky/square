package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Contact;

import java.util.List;

public interface ContactDAO {

    void addContact(Contact contact);

    List<Contact> listContact();

    void removeContact(Integer id);

    void updateContact(Contact contact);

    Contact getContactById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);

}
