package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Typeofspec;

import java.util.List;

public interface TypeofspecDAO {

    List<Typeofspec> listTypeofspecs();

    Typeofspec saveTypeofspec(Typeofspec typeofspec);

    Typeofspec getTypeofspecById(Long id);

    void removeTypeofspec(Long id);
}
