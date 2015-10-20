package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Offer;

import java.util.List;

public interface OfferService {

    void addOffer(Offer offer);

    List<Offer> listOffer();

    void removeOffer(Integer id);

}
