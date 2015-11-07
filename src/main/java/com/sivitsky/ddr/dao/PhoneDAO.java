package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Phone;

import java.util.List;

public interface PhoneDAO {

    List<Phone> listPhones();

    Phone savePhone(Phone phone);

    Phone getPhoneById(Long id);

    void removePhone(Long id);
}
