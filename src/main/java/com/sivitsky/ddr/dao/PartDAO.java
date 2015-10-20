package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Part;

import java.util.List;

public interface PartDAO {

    void addPart(Part part);

    List<Part> listPart();

    void removePart(Integer id);

    void updatePart(Part part);

    Part getPartById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
