package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Phone;

import java.util.List;

public interface PhoneDAO {

    public void addPhone(Phone phone);

    public List<Phone> listPhone();

    public void removePhone(Integer id);

    public void updatePhone(Phone phone);

    public Phone getPhoneById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
