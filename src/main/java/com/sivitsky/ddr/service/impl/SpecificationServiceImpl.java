package com.sivitsky.ddr.service.impl;

import com.sivitsky.ddr.dao.SpecificationDAO;
import com.sivitsky.ddr.model.Specification;
import com.sivitsky.ddr.service.SpecificationService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class SpecificationServiceImpl implements SpecificationService {

    //    @Autowired
    private SpecificationDAO specificationDAO;

    @Transactional
    public void addSpecification(Specification specification) {
        specificationDAO.addSpecification(specification);
    }

    @Transactional
    public List<Specification> listSpecification() {

        return specificationDAO.listSpecification();
    }

    @Transactional
    public void removeSpecification(Integer id) {
        specificationDAO.removeSpecification(id);
    }

}
