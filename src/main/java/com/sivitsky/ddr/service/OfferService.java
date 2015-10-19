package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Offer;

import java.util.List;

public interface OfferService {

    public void addOffer(Offer offer);

    public List<Offer> listOffer();

    public void removeOffer(Integer id);

}
