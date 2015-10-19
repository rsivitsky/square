package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Part;

import java.util.List;

public interface PartDAO {

    public void addPart(Part part);

    public List<Part> listPart();

    public void removePart(Integer id);

    public void updatePart(Part part);

    public Part getPartById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
