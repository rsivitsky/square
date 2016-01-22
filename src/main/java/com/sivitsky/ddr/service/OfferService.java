package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Offer;

import java.util.List;

public interface OfferService {

    Offer saveOffer(Offer offer);

    List<Offer> listOffer();

    List<Offer> getOffersByVendorId(Long vendor_id);

    void removeOffer(Long id);

    Offer getOfferById(Long id);

}
