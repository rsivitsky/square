package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.MeasureDAO;
import com.sivitsky.ddr.model.Measure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MeasureServiceImpl implements MeasureService {

    @Autowired
    private MeasureDAO measureDAO;

    @Transactional
    public void addMeasure(Measure measure) {
        measureDAO.addMeasure(measure);
    }

    @Transactional
    public List<Measure> listMeasure() {

        return measureDAO.listMeasure();
    }

    @Transactional
    public void removeMeasure(Integer id) {
        measureDAO.removeMeasure(id);
    }

}
