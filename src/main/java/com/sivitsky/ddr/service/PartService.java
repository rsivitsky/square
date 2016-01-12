package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Part;

import java.util.List;

public interface PartService {

    Part savePart(Part part);

    List<Part> listPart();

    List<Part> listPartWithDetail();

    List<Part> listPartWithManufactursFilter(Long[] mas_id);

    void removePart(Long id);

    Part getPartById(Long id);

}
