package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Description;

import java.util.List;

public interface DescriptionDAO {

    void addDescription(Description description);

    List<Description> listDescription();

    void removeDescription(Integer id);

    void updateDescription(Description description);

    Description getDescriptionById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);

}