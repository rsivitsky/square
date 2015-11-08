package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Vendor;

import java.util.List;

public interface VendorDAO {

    List<Vendor> listVendor();

    Vendor saveVendor(Vendor Vendor);

    Vendor getVendorById(Long id);

    void removeVendor(Long id);

}
