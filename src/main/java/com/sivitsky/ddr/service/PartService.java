package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Part;

import java.util.List;

public interface PartService {

    Part savePart(Part part);

    List<Part> listPart();

    List<Part> listPartWithDetail();

    List<Part> listPartWithManufactursFilter(Long[] mas_id);

    List<Part> listPartByManufactIdAndPrice(Long[] mas_id, Float price_from, Float price_to);

    void removePart(Long id);

    Part getPartById(Long id);

    Part getPartByName(String name);

}
