package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Description;

import java.util.List;

public interface DescriptionDAO {

    List<Description> listDescription();

    List<Description> listDescriptionByPartId(Long id);

    Description saveDescription(Description description);

    Description getDescriptionById(Long id);

    void removeDescription(Long id);

}