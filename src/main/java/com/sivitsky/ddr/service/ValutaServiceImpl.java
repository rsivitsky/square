package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.ValutaDAO;
import com.sivitsky.ddr.model.Valuta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ValutaServiceImpl implements ValutaService {

    @Autowired
    private ValutaDAO valutaDAO;

    @Transactional
    public void addValuta(Valuta valuta) {
        valutaDAO.addValuta(valuta);
    }

    @Transactional
    public List<Valuta> listValuta() {

        return valutaDAO.listValuta();
    }

    @Transactional
    public void removeValuta(Integer id) {
        valutaDAO.removeValuta(id);
    }

}
