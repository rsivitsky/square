package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.CurrencyDAO;
import com.sivitsky.ddr.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDAO currencyDAO;

    @Transactional
    public Currency saveCurrency(Currency currency) {
        return currencyDAO.saveCurrency(currency);
    }

    @Transactional
    public List<Currency> listCurrency() {
        return currencyDAO.listCurrency();
    }

    @Transactional
    public void removeCurrency(Long id) {
        currencyDAO.removeCurrency(id);
    }

    public void setCurrencyDAO(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    @Transactional
    public Currency getCurrencyById(Long id) {
        return this.currencyDAO.getCurrencyById(id);
    }

}
