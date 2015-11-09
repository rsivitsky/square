package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.OfferDAO;
import com.sivitsky.ddr.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OfferServiceImpl implements OfferService {

    private OfferDAO offerDAO;

    @Transactional
    public Offer saveOffer(Offer offer) {
        return offerDAO.saveOffer(offer);
    }

    @Transactional
    public List<Offer> listOffer() {
        return offerDAO.listOffer();
    }

    @Transactional
    public void removeOffer(Long id) {
        offerDAO.removeOffer(id);
    }

    @Autowired
    public void setOfferDAO(OfferDAO offerDAO) {
        this.offerDAO = offerDAO;
    }

    @Transactional
    public Offer getOfferById(Long id) {
        return this.offerDAO.getOfferById(id);
    }

}
