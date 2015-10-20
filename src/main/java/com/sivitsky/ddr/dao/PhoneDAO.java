package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Phone;

import java.util.List;

public interface PhoneDAO {

    void addPhone(Phone phone);

    List<Phone> listPhone();

    void removePhone(Integer id);

    void updatePhone(Phone phone);

    Phone getPhoneById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
