package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Offer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//@Repository
public class OfferDAOImpl implements OfferDAO {

    private static final Logger logger = LoggerFactory.getLogger(OfferDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addOffer(Offer offer) {
        sessionFactory.getCurrentSession().save(offer);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Offer> listOffer() {

        return sessionFactory.getCurrentSession().createQuery("from Offer")
                .list();
    }

    @Override
    public void removeOffer(Integer id) {
        Offer offer = (Offer) sessionFactory.getCurrentSession().load(
                Offer.class, id);
        if (null != offer) {
            sessionFactory.getCurrentSession().delete(offer);
        }

    }

    @Override
    public Offer getOfferById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Offer offer = (Offer) session.load(Offer.class, new Integer(id));
        logger.info("Offer loaded successfully, Offer details="+offer);
        return offer;
    }

    @Override
    public void updateOffer(Offer offer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(offer);
        logger.info("Offer updated successfully, Offer Details="+offer);
    }
}
