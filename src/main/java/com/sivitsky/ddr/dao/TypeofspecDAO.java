package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Typeofspec;

import java.util.List;

public interface TypeofspecDAO {

    public void addTypeofspec(Typeofspec typeofspec);

    public List<Typeofspec> listTypeofspec();

    public void removeTypeofspec(Integer id);

    public void updateTypeofspec(Typeofspec typeofspec);

    public Typeofspec getTypeofspecById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
