package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Vendor;

import java.util.List;

public interface VendorService {

    void addVendor(Vendor vendor);

    void updateVendor(Vendor vendor);

    List<Vendor> listVendor();

    void removeVendor(Integer id);

    Vendor getVendorById(Integer id);

}
