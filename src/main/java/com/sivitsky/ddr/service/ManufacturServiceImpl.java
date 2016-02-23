package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.ManufacturDAO;
import com.sivitsky.ddr.model.Manufactur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManufacturServiceImpl implements ManufacturService {

    @Autowired
    private ManufacturDAO manufacturDAO;

    @Transactional
    public Manufactur saveManufactur(Manufactur manufactur) {
        return manufacturDAO.saveManufactur(manufactur);
    }

    @Transactional
    public List<Manufactur> listManufactur() {
        return manufacturDAO.listManufactur();
    }

    @Transactional
    public void removeManufactur(Long id) {
        manufacturDAO.removeManufactur(id);
    }

    @Transactional
    public Manufactur getManufacturById(Long id) {
        return this.manufacturDAO.getManufacturById(id);
    }
}
