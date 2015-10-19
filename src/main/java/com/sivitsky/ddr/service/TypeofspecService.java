package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Typeofspec;

import java.util.List;

public interface TypeofspecService {

    public void addTypeofspec(Typeofspec typeofspec);

    public List<Typeofspec> listTypeofspec();

    public void removeTypeofspec(Integer id);

}
