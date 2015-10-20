package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Specification;

import java.util.List;

public interface SpecificationService {

    void addSpecification(Specification specification);

    List<Specification> listSpecification();

    void removeSpecification(Integer id);

}
