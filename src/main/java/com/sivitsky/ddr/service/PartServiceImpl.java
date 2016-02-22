package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.PartDAO;
import com.sivitsky.ddr.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PartServiceImpl implements PartService {

    private PartDAO partDAO;

    @Transactional
    public Part savePart(Part part) {
        return partDAO.savePart(part);
    }

    @Transactional
    public List<Part> listPart() {
        return partDAO.listPart();
    }

    @Transactional
    public List<Object[]> listPartWithDetail(Integer firstResult, Integer maxResult){
        return partDAO.listPartWithDetail(firstResult, maxResult);
    }

    @Transactional
    public List<Part> listPartWithManufactursFilter(Long[] mas_id){
        return partDAO.listPartWithManufactursFilter(mas_id);
    }

    @Transactional
    public List<Part> listPartByManufactIdAndPrice(Long[] mas_id, Float price_from, Float price_to){
        return partDAO.listPartByManufactIdAndPrice(mas_id, price_from, price_to);
    }

    @Transactional
    public void removePart(Long id) {
        partDAO.removePart(id);
    }

    @Autowired
    public void setPartDAO(PartDAO partDAO) {
        this.partDAO = partDAO;
    }

    @Transactional
    public Part getPartById(Long id) {
        return this.partDAO.getPartById(id);
    }

    @Transactional
    public Part getPartByName(String name) {
        return this.partDAO.getPartByName(name);
    }

}
