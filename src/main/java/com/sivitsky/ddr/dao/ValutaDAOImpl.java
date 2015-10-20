package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Currency;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ValutaDAOImpl implements ValutaDAO {

    private static final Logger logger = LoggerFactory.getLogger(ValutaDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addValuta(Currency currency) {
        sessionFactory.getCurrentSession().save(currency);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Currency> listValuta() {

        return sessionFactory.getCurrentSession().createQuery("from Valuta")
                .list();
    }

    @Override
    public void removeValuta(Integer id) {
        Currency currency = (Currency) sessionFactory.getCurrentSession().load(
                Currency.class, id);
        if (null != currency) {
            sessionFactory.getCurrentSession().delete(currency);
        }

    }

    @Override
    public Currency getValutaById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Currency currency = (Currency) session.load(Currency.class, new Integer(id));
        logger.info("Currency loaded successfully, Currency details=" + currency);
        return currency;
    }

    @Override
    public void updateValuta(Currency currency) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(currency);
        logger.info("Currency updated successfully, Currency Details=" + currency);
    }

}
