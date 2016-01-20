package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Currency;

import java.util.List;

public interface CurrencyService {

    Currency saveCurrency(Currency currency);

    List<Currency> listCurrency();

    void removeCurrency(Long id);

    Currency getCurrencyById(Long id);

    Currency getCurrencyByName(String name);

}
