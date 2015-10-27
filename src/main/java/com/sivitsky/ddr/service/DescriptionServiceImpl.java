package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.DescriptionDAO;
import com.sivitsky.ddr.model.Description;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DescriptionServiceImpl implements DescriptionService {

    //    @Autowired
    private DescriptionDAO descriptionDAO;

    @Transactional
    public void addDescription(Description description) {
        descriptionDAO.addDescription(description);
    }

    @Transactional
    public List<Description> listDescription() {

        return descriptionDAO.listDescription();
    }

    @Transactional
    public void removeDescription(Integer id) {
        descriptionDAO.removeDescription(id);
    }

}
