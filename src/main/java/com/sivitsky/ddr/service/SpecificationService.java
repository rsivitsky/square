package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Specification;

import java.util.List;

public interface SpecificationService {

    Specification saveSpecification(Specification specification);

    List<Specification> listSpecification();

    void removeSpecification(Long id);

    Specification getSpecificationById(Long id);

}
