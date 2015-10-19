package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Valuta;

import java.util.List;

public interface ValutaService {

    public void addValuta(Valuta valuta);

    public List<Valuta> listValuta();

    public void removeValuta(Integer id);

}
