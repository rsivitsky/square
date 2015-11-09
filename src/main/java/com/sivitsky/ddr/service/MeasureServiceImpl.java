package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.MeasureDAO;
import com.sivitsky.ddr.model.Measure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MeasureServiceImpl implements MeasureService {

    private MeasureDAO measureDAO;

    @Transactional
    public Measure saveMeasure(Measure measure) {
        return  measureDAO.saveMeasure(measure);
    }

    @Transactional
    public List<Measure> listMeasure() {
        return measureDAO.listMeasure();
    }

    @Transactional
    public void removeMeasure(Long id) {
        measureDAO.removeMeasure(id);
    }

    @Autowired
    public void setMeasureDAO(MeasureDAO measureDAO) {
        this.measureDAO = measureDAO;
    }

    @Transactional
    public Measure getMeasureById(Long id){
        return measureDAO.getMeasureById(id);
    }

}
