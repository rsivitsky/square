package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Currency;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CurrencyDAOImpl implements CurrencyDAO{

    private static final Logger logger = LoggerFactory.getLogger(CurrencyDAOImpl.class);
    private SessionFactory sessionFactory;

    @Autowired(required=true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Currency saveCurrency(Currency currency) {
        sessionFactory.getCurrentSession().saveOrUpdate(currency);
        logger.info("Currency updated successfully, Currency id=" + currency.getValuta_id());
        return currency;
    }

    @SuppressWarnings("unchecked")
    public List<Currency> listCurrency() {
        return sessionFactory.getCurrentSession().createQuery("from Currency").list();
    }

    public Currency getCurrencyById(Long id) {
        return (Currency) this.sessionFactory.getCurrentSession().get(Currency.class, id);
    }

    public void removeCurrency(Long id) {
        Currency currency = (Currency) sessionFactory.getCurrentSession().load(Currency.class, id);
        if (null != currency) {
            sessionFactory.getCurrentSession().delete(currency);
        }
    }
}
