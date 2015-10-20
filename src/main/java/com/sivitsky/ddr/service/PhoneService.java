package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Phone;

import java.util.List;

public interface PhoneService {

    void addPhone(Phone phone);

    List<Phone> listPhone();

    void removePhone(Integer id);

}
