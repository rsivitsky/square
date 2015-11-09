package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Measure;

import java.util.List;

public interface MeasureService {

    Measure saveMeasure(Measure measure);

    List<Measure> listMeasure();

    void removeMeasure(Long id);

    Measure getMeasureById(Long id);

}
