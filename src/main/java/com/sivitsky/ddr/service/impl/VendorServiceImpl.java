package com.sivitsky.ddr.service.impl;

import com.sivitsky.ddr.model.Vendor;
import com.sivitsky.ddr.repository.VendorRepository;
import com.sivitsky.ddr.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository repository;

    @Transactional
    public void addVendor(Vendor vendor) {
        repository.save(vendor);
    }

    @Transactional
    public void updateVendor(Vendor vendor) {
        repository.save(vendor);
    }

    @Transactional
    public List<Vendor> listVendor() {
        return repository.getAllVendors();
    }

    @Transactional
    public void removeVendor(Long id) {
        repository.delete(id);
    }

    @Transactional
    public Vendor getVendorById(Long id) {
        return repository.findOne(id);
    }

}
