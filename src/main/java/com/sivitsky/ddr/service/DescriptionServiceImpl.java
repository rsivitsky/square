package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.DescriptionDAO;
import com.sivitsky.ddr.model.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DescriptionServiceImpl implements DescriptionService {

    @Autowired
    private DescriptionDAO descriptionDAO;

    @Transactional
    public Description saveDescription(Description description) {
        return descriptionDAO.saveDescription(description);
    }

    @Transactional
    public List<Description> listDescription() {
        return descriptionDAO.listDescription();
    }

    @Transactional
    public void removeDescription(Long id) {
        descriptionDAO.removeDescription(id);
    }

    public void setDescriptionDAO(DescriptionDAO descriptionDAO) {
        this.descriptionDAO = descriptionDAO;
    }

    @Transactional
    public Description getDescriptionById(Long id) {
        return this.descriptionDAO.getDescriptionById(id);
    }

}
