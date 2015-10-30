package com.sivitsky.ddr.service.impl;

import com.sivitsky.ddr.dao.OfferDAO;
import com.sivitsky.ddr.model.Offer;
import com.sivitsky.ddr.service.OfferService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OfferServiceImpl implements OfferService {

    //    @Autowired
    private OfferDAO offerDAO;

    @Transactional
    public void addOffer(Offer offer) {
        offerDAO.addOffer(offer);
    }

    @Transactional
    public List<Offer> listOffer() {

        return offerDAO.listOffer();
    }

    @Transactional
    public void removeOffer(Integer id) {
        offerDAO.removeOffer(id);
    }

}
