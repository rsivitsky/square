package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.CurrencyDAO;
import com.sivitsky.ddr.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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

    @Transactional
    public Currency getCurrencyById(Long id) {
        return this.currencyDAO.getCurrencyById(id);
    }

    @Transactional
    public Currency getCurrencyByName(String name) {
        return this.currencyDAO.getCurrencyByName(name);
    }
}
