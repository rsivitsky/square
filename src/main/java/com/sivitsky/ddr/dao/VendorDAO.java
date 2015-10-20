package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Vendor;

import java.util.List;

public interface VendorDAO {

    void addVendor(Vendor vendor);

    List<Vendor> listVendor();

    void removeVendor(Integer id);

    void updateVendor(Vendor vendor);

    Vendor getVendorById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
