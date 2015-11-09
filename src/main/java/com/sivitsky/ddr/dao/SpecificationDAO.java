package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Specification;

import java.util.List;

public interface SpecificationDAO {

    List<Specification> listSpecification();

    Specification saveSpecification(Specification specification);

    Specification getSpecificationById(Long id);

    void removeSpecification(Long id);
}
