package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Description;
import com.sivitsky.ddr.model.Measure;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeasureDAOImpl implements MeasureDAO {

    private static final Logger logger = LoggerFactory.getLogger(MeasureDAOImpl.class);
    private SessionFactory sessionFactory;

    @Autowired(required=true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Measure saveMeasure(Measure measure) {
        sessionFactory.getCurrentSession().saveOrUpdate(measure);
        logger.info("Measure updated successfully, Measure id=" + measure.getMeasure_id());
        return measure;
    }

    @SuppressWarnings("unchecked")
    public List<Measure> listMeasure() {
        return sessionFactory.getCurrentSession().createQuery("from measure").list();
    }

    public Measure getMeasureById(Long id) {
        return (Measure) this.sessionFactory.getCurrentSession().get(Measure.class, id);
    }

    public void removeMeasure(Long id) {
        Measure measure = (Measure) sessionFactory.getCurrentSession().load(Measure.class, id);
        if (null != measure) {
            sessionFactory.getCurrentSession().delete(measure);
        }
    }
}
