package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.ContactDAO;
import com.sivitsky.ddr.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ContactServiceImpl implements ContactService {

    private ContactDAO contactDAO;

    @Transactional
    public Contact saveContact(Contact contact) {
        return this.contactDAO.saveContact(contact);
    }

    @Transactional
    public List<Contact> listContact() {
        return this.contactDAO.listContact();
    }

    @Transactional
    public Contact getContactById(Long id) {
        return this.contactDAO.getContactById(id);
    }

    @Transactional
    public void removeContact(Long id) {
        this.contactDAO.removeContact(id);
    }

    @Autowired(required=true)
    public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

}
