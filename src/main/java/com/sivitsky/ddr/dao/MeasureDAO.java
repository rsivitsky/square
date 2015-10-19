package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Measure;

import java.util.List;

public interface MeasureDAO {

    public void addMeasure(Measure measure);

    public List<Measure> listMeasure();

    public void removeMeasure(Integer id);

    public void updateMeasure(Measure measure);

    public Measure getMeasureById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);

}
