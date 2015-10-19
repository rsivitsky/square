package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Vendor;

import java.util.List;

public interface VendorService {

    public void addVendor(Vendor vendor);

    public List<Vendor> listVendor();

    public void removeVendor(Integer id);

}
