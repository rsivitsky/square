package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Measure;
import com.sivitsky.ddr.model.Offer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfferDAOImpl implements OfferDAO {

    private static final Logger logger = LoggerFactory.getLogger(OfferDAOImpl.class);
    private SessionFactory sessionFactory;

    @Autowired(required=true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Offer saveOffer(Offer offer) {
        sessionFactory.getCurrentSession().saveOrUpdate(offer);
        logger.info("Offer updated successfully, offer id=" + offer.getOffer_id());
        return offer;
    }

    @SuppressWarnings("unchecked")
    public List<Offer> listOffer() {
        return sessionFactory.getCurrentSession().createQuery("from Offer").list();
    }

    public Offer getOfferById(Long id) {
        return (Offer) this.sessionFactory.getCurrentSession().get(Offer.class, id);
    }

    public void removeOffer(Long id) {
        Offer offer = (Offer) sessionFactory.getCurrentSession().load(Offer.class, id);
        if (null != offer) {
            sessionFactory.getCurrentSession().delete(offer);
        }
    }

    public List<Offer> getOffersByVendorId(Long vendor_id){
       return sessionFactory.getCurrentSession().getNamedQuery("Offer.getOffersByVendorId")
                .setParameter("vendor_id", vendor_id).list();
    }

    public List<Offer> getOffersByPartId(Long part_id){
        return sessionFactory.getCurrentSession().getNamedQuery("Offer.getOffersByPartId")
                .setParameter("part_id", part_id).list();
    }
}
