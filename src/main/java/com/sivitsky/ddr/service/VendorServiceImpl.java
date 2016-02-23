package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.VendorDAO;
import com.sivitsky.ddr.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorDAO vendorDAO;

    @Transactional
    public Vendor saveVendor(Vendor vendor) {
        return vendorDAO.saveVendor(vendor);
    }

    @Transactional
    public List<Vendor> listVendor() {
        return vendorDAO.listVendor();
    }

    @Transactional
    public void removeVendor(Long id) {
        vendorDAO.removeVendor(id);
    }

    @Transactional
    public Vendor getVendorById(Long id) {
        return this.vendorDAO.getVendorById(id);
    }
}
