package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Offer;

import java.util.List;

public interface OfferDAO {

    public void addOffer(Offer offer);

    public List<Offer> listOffer();

    public void removeOffer(Integer id);

    public void updateOffer(Offer offer);

    public Offer getOfferById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
