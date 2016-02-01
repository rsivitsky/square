package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Offer;

public class OfferFilterService {

    private Offer offer;
    private Boolean usage;

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Boolean getUsage() {
        return usage;
    }

    public void setUsage(Boolean usage) {
        this.usage = usage;
    }

}
