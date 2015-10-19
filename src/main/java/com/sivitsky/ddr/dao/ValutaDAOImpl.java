package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Specification;
import com.sivitsky.ddr.model.Valuta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addValuta(Valuta valuta) {
        sessionFactory.getCurrentSession().save(valuta);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Valuta> listValuta() {

        return sessionFactory.getCurrentSession().createQuery("from Valuta")
                .list();
    }

    @Override
    public void removeValuta(Integer id) {
        Valuta valuta = (Valuta) sessionFactory.getCurrentSession().load(
                Valuta.class, id);
        if (null != valuta) {
            sessionFactory.getCurrentSession().delete(valuta);
        }

    }

    @Override
    public Valuta getValutaById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Valuta valuta = (Valuta) session.load(Valuta.class, new Integer(id));
        logger.info("Valuta loaded successfully, Valuta details="+valuta);
        return valuta;
    }

    @Override
    public void updateValuta(Valuta valuta) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(valuta);
        logger.info("Valuta updated successfully, Valuta Details="+valuta);
    }

}
