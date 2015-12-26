package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Manufactur;

import java.util.List;

public interface ManufacturDAO {

    List<Manufactur> listManufactur();

    Manufactur saveManufactur(Manufactur manufactur);

    Manufactur getManufacturById(Long id);

    void removeManufactur(Long id);

}
