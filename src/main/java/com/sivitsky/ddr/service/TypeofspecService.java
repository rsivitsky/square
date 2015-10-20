package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Typeofspec;

import java.util.List;

public interface TypeofspecService {

    void addTypeofspec(Typeofspec typeofspec);

    List<Typeofspec> listTypeofspec();

    void removeTypeofspec(Integer id);
}
