package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Vendor;

import java.util.List;

public interface VendorDAO {

    public void addVendor(Vendor vendor);

    public List<Vendor> listVendor();

    public void removeVendor(Integer id);

    public void updateVendor(Vendor vendor);

    public Vendor getVendorById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
