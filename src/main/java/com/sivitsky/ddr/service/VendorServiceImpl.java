package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.VendorDAO;
import com.sivitsky.ddr.model.Vendor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    //    @Autowired
    private VendorDAO vendorDAO;

    @Transactional
    public void addVendor(Vendor vendor) {
        vendorDAO.addVendor(vendor);
    }

    @Transactional
    public void updateVendor(Vendor vendor) {
        vendorDAO.updateVendor(vendor);
    }

    @Transactional
    public List<Vendor> listVendor() {

        return vendorDAO.listVendor();
    }

    @Transactional
    public void removeVendor(Integer id) {
        vendorDAO.removeVendor(id);
    }

    public void setVendorDAO(com.sivitsky.ddr.dao.VendorDAOImpl vendorDAO) {
    }

    @Transactional
    public Vendor getVendorById(Integer id) {
        return this.vendorDAO.getVendorById(id);
    }

}
