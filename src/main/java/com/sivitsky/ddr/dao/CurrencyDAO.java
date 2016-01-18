package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Currency;

import java.util.List;

public interface CurrencyDAO {

    List<Currency> listCurrency();

    Currency saveCurrency(Currency currency);

    Currency getCurrencyById(Long id);

    Currency getCurrencyByName(String name);

    void removeCurrency(Long id);
}
