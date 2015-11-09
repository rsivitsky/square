package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Typeofspec;

import java.util.List;

public interface TypeofspecService {

    Typeofspec saveTypeofspec(Typeofspec typeofspec);

    List<Typeofspec> listTypeofspec();

    void removeTypeofspec(Long id);

    Typeofspec getTypeofspecByID(Long id);
}
