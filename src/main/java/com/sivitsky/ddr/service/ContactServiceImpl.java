package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.ContactDAO;
import com.sivitsky.ddr.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Transactional
    public Contact saveContact(Contact contact) {
        return contactDAO.saveContact(contact);
    }

    @Transactional
    public List<Contact> listContact() {
        return contactDAO.listContact();
    }

    @Transactional
    public void removeContact(Long id) {
        contactDAO.removeContact(id);
    }

    public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @Transactional
    public Contact getContactById(Long id) {
        return this.contactDAO.getContactById(id);
    }

}
