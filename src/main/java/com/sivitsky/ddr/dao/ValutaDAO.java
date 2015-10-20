package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Currency;

import java.util.List;

public interface ValutaDAO {

    void addValuta(Currency currency);

    List<Currency> listValuta();

    void removeValuta(Integer id);

    void updateValuta(Currency currency);

    Currency getValutaById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
