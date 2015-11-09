package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Measure;

import java.util.List;

public interface MeasureDAO {

    List<Measure> listMeasure();

    Measure saveMeasure(Measure measure);

    Measure getMeasureById(Long id);

    void removeMeasure(Long id);

}
