package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.DescriptionDAO;
import com.sivitsky.ddr.model.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
    public List<Description> listDescriptionByPartId(Long id) {
        return descriptionDAO.listDescriptionByPartId(id);
    }

    @Transactional
    public void removeDescription(Long id) {
        descriptionDAO.removeDescription(id);
    }

    @Transactional
    public Description getDescriptionById(Long id) {
        return this.descriptionDAO.getDescriptionById(id);
    }
}
