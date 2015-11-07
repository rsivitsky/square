package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Contact;

import java.util.List;

public interface ContactDAO {

    List<Contact> listContact();

    Contact saveContact(Contact contact);

    Contact getContactById(Long id);

    void removeContact(Long id);

}
