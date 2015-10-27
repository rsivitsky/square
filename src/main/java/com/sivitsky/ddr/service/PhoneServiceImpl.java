package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.PhoneDAO;
import com.sivitsky.ddr.model.Phone;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {

    //    @Autowired
    private PhoneDAO phoneDAO;

    @Transactional
    public void addPhone(Phone phone) {
        phoneDAO.addPhone(phone);
    }

    @Transactional
    public List<Phone> listPhone() {

        return phoneDAO.listPhone();
    }

    @Transactional
    public void removePhone(Integer id) {
        phoneDAO.removePhone(id);
    }

}
