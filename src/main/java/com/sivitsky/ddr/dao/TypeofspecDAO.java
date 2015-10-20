package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Typeofspec;

import java.util.List;

public interface TypeofspecDAO {

    void addTypeofspec(Typeofspec typeofspec);

    List<Typeofspec> listTypeofspec();

    void removeTypeofspec(Integer id);

    void updateTypeofspec(Typeofspec typeofspec);

    Typeofspec getTypeofspecById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
