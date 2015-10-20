package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Measure;

import java.util.List;

public interface MeasureService {

    void addMeasure(Measure measure);

    List<Measure> listMeasure();

    void removeMeasure(Integer id);

}
