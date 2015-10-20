package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Currency;

import java.util.List;

public interface CurrencyService {

    void addValuta(Currency currency);

    List<Currency> listValuta();

    void removeValuta(Integer id);

}
