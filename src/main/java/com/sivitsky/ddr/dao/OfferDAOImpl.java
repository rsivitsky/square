package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Offer;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfferDAOImpl implements OfferDAO {

    private static final Logger logger = LoggerFactory.getLogger(OfferDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

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

    @SuppressWarnings("unchecked")
    public List<Offer> getOffersByVendorId(Long vendor_id) {
        return sessionFactory.getCurrentSession().getNamedQuery("Offer.getOffersByVendorId")
                .setParameter("vendor_id", vendor_id).list();
    }

    @SuppressWarnings("unchecked")
    public List<Offer> getOffersByPartId(Long part_id, Float price_from, Float price_to) {
        return sessionFactory.getCurrentSession().getNamedQuery("Offer.getOffersByPartId")
                .setParameter("part_id", part_id)
                .setParameter("price_from", price_from).setParameter("price_to", price_to)
                .list();
    }

    @SuppressWarnings("unchecked")
    public Object getOffersMaxAndMinPrice(Long part_id, Float price_from, Float price_to) {
        return sessionFactory.getCurrentSession().getNamedQuery("Offer.getOffersMaxAndMinPrice")
                .setParameter("part_id", part_id)
                .setParameter("price_from", price_from).setParameter("price_to", price_to)
                .uniqueResult();
    }
}
