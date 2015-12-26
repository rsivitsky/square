package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Manufactur;

import java.util.List;

public interface ManufacturService {

    Manufactur saveManufactur(Manufactur manufactur);

    List<Manufactur> listManufactur();

    void removeManufactur(Long id);

    Manufactur getManufacturById(Long id);

}
