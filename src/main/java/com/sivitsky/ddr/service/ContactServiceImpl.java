package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.ContactDAO;
import com.sivitsky.ddr.model.Contact;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ContactServiceImpl implements ContactService {
    //
//    @Qualifier("contactDAOImpl")
//    @Autowired
    private ContactDAO contactDAO;

    @Transactional
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    @Transactional
    public List<Contact> listContact() {

        return contactDAO.listContact();
    }

    @Transactional
    public void removeContact(Integer id) {
        contactDAO.removeContact(id);
    }

}
