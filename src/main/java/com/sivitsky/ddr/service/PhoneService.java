package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Phone;

import java.util.List;

public interface PhoneService {

    public void addPhone(Phone phone);

    public List<Phone> listPhone();

    public void removePhone(Integer id);

}
