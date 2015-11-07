package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Vendor;

import java.util.List;

public interface VendorDAO {

    Vendor saveVendor(Vendor vendor);

    List<Vendor> listVendor();

    void removeVendor(Long id);

    Vendor getVendorById(Long id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);

}
