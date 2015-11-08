package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Part;

import java.util.List;

public interface PartDAO {

    List<Part> listPart();

    Part savePart(Part Part);

    Part getPartById(Long id);

    void removePart(Long id);
}
