package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.ValutaDAO;
import com.sivitsky.ddr.model.Currency;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CurrencyServiceImpl implements CurrencyService {

    //    @Autowired
    private ValutaDAO valutaDAO;

    @Transactional
    public void addValuta(Currency currency) {
        valutaDAO.addValuta(currency);
    }

    @Transactional
    public List<Currency> listValuta() {

        return valutaDAO.listValuta();
    }

    @Transactional
    public void removeValuta(Integer id) {
        valutaDAO.removeValuta(id);
    }

}
