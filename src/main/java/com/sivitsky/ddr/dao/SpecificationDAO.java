package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Specification;

import java.util.List;

public interface SpecificationDAO {

    void addSpecification(Specification specification);

    List<Specification> listSpecification();

    void removeSpecification(Integer id);

    void updateSpecification(Specification specification);

    Specification getSpecificationById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
