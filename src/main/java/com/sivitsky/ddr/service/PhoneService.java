package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Phone;

import java.util.List;

public interface PhoneService {

    Phone savePhone(Phone phone);

    List<Phone> listPhones();

    void removePhone(Long id);

    Phone getPhoneById(Long id);

}
