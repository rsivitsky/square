package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Specification;

import java.util.List;

public interface SpecificationService {

    public void addSpecification(Specification specification);

    public List<Specification> listSpecification();

    public void removeSpecification(Integer id);

}
