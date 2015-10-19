package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Valuta;

import java.util.List;

public interface ValutaDAO {

    public void addValuta(Valuta valuta);

    public List<Valuta> listValuta();

    public void removeValuta(Integer id);

    public void updateValuta(Valuta valuta);

    public Valuta getValutaById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
