package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.PhoneDAOImpl;
import com.sivitsky.ddr.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneDAOImpl phoneDAO;

    @Transactional
    public Phone savePhone(Phone phone) {
        return this.phoneDAO.savePhone(phone);
    }

    @Transactional
    public List<Phone> listPhones() {
        return this.phoneDAO.listPhones();
    }

    @Transactional
    public Phone getPhoneById(Long id) {
        return this.phoneDAO.getPhoneById(id);
    }

    @Transactional
    public void removePhone(Long id) {
        this.phoneDAO.removePhone(id);
    }
}
