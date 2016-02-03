package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Offer;

import java.util.List;

public interface OfferDAO {

    List<Offer> listOffer();

    Offer saveOffer(Offer offer);

    Offer getOfferById(Long id);

    List<Offer> getOffersByVendorId(Long id);

    List<Offer> getOffersByPartId(Long id, Float price_from, Float price_to);

    void removeOffer(Long id);
}
