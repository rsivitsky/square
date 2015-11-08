package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Currency;

import java.util.List;

public interface CurrencyDAO {

    List<Currency> listCurrency();

    Currency saveCurrency(Currency currency);

    Currency getCurrencyById(Long id);

    void removeCurrency(Long id);
}
