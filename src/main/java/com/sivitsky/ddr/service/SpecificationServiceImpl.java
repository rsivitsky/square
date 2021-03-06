package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.SpecificationDAO;
import com.sivitsky.ddr.model.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private SpecificationDAO specificationDAO;

    @Transactional
    public Specification saveSpecification(Specification specification) {
        return specificationDAO.saveSpecification(specification);
    }

    @Transactional
    public List<Specification> listSpecification() {
        return specificationDAO.listSpecification();
    }

    @Transactional
    public void removeSpecification(Long id) {
        specificationDAO.removeSpecification(id);
    }

    @Transactional
    public Specification getSpecificationById(Long id) {
        return this.specificationDAO.getSpecificationById(id);
    }
}
