package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Specification;

import java.util.List;

public interface SpecificationDAO {

    public void addSpecification(Specification specification);

    public List<Specification> listSpecification();

    public void removeSpecification(Integer id);

    public void updateSpecification(Specification specification);

    public Specification getSpecificationById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
