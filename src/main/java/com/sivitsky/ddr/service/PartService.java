package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Part;

import java.util.List;

public interface PartService {

    public void addPart(Part part);

    public List<Part> listPart();

    public void removePart(Integer id);

}
