package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Description;

import java.util.List;

public interface DescriptionService {

    void addDescription(Description description);

    List<Description> listDescription();

    void removeDescription(Integer id);

}
