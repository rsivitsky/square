package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Offer;

import java.util.List;

public interface OfferDAO {

    void addOffer(Offer offer);

    List<Offer> listOffer();

    void removeOffer(Integer id);

    void updateOffer(Offer offer);

    Offer getOfferById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
