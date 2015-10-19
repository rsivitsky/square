package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Measure;

import java.util.List;

public interface MeasureService {

    public void addMeasure(Measure measure);

    public List<Measure> listMeasure();

    public void removeMeasure(Integer id);

}
