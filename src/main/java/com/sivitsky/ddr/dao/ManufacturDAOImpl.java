package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Manufactur;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManufacturDAOImpl implements ManufacturDAO {

    private static final Logger logger = LoggerFactory.getLogger(ManufacturDAOImpl.class);
    private SessionFactory sessionFactory;

    @Autowired(required=true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Manufactur saveManufactur(Manufactur manufactur) {
        sessionFactory.getCurrentSession().saveOrUpdate(manufactur);
        logger.info("Manufactur updated successfully, manufactur id=" + manufactur.getManufactur_id());
        return manufactur;
    }

    @SuppressWarnings("unchecked")
    public List<Manufactur> listManufactur() {
        return sessionFactory.getCurrentSession().createQuery("from Manufactur").list();
    }

    public Manufactur getManufacturById(Long id) {
        return (Manufactur) this.sessionFactory.getCurrentSession().get(Manufactur.class, id);
    }

    public void removeManufactur(Long id) {
        Manufactur manufactur = (Manufactur) sessionFactory.getCurrentSession().load(Manufactur.class, id);
        if (null != manufactur) {
            sessionFactory.getCurrentSession().delete(manufactur);
        }
    }

}
