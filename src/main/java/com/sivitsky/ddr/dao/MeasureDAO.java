package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Measure;

import java.util.List;

public interface MeasureDAO {

    void addMeasure(Measure measure);

    List<Measure> listMeasure();

    void removeMeasure(Integer id);

    void updateMeasure(Measure measure);

    Measure getMeasureById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);

}
