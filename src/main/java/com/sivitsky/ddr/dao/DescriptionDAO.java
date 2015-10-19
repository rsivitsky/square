package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Description;

import java.util.List;

public interface DescriptionDAO {

    public void addDescription(Description description);

    public List<Description> listDescription();

    public void removeDescription(Integer id);

    public void updateDescription(Description description);

    public Description getDescriptionById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);

}