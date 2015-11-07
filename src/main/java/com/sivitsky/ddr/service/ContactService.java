package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Contact;

import java.util.List;

public interface ContactService {

    Contact saveContact(Contact contact);

    List<Contact> listContact();

    void removeContact(Long id);

    Contact getContactById(Long id);

}