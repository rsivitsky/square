package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Part;

import java.util.List;

public interface PartService {

    void addPart(Part part);

    List<Part> listPart();

    void removePart(Integer id);

}
