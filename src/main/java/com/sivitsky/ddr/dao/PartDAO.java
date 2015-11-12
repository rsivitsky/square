package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Part;

import java.util.List;

public interface PartDAO {

    List<Part> listPart();

    List<Part> listPartWithDetail();

    Part savePart(Part part);

    Part getPartById(Long id);

    void removePart(Long id);
}
