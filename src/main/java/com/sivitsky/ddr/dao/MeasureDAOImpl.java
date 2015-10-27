package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Measure;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//@Repository
public class MeasureDAOImpl implements MeasureDAO {

    private static final Logger logger = LoggerFactory.getLogger(MeasureDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addMeasure(Measure measure) {
        sessionFactory.getCurrentSession().save(measure);
    }

    @SuppressWarnings("unchecked")
    public List<Measure> listMeasure() {

        return sessionFactory.getCurrentSession().createQuery("from Measure")
                .list();
    }

    @Override
    public void removeMeasure(Integer id) {
        Measure measure = (Measure) sessionFactory.getCurrentSession().load(
                Measure.class, id);
        if (null != measure) {
            sessionFactory.getCurrentSession().delete(measure);
        }

    }

    @Override
    public Measure getMeasureById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Measure measure = (Measure) session.load(Measure.class, new Integer(id));
        logger.info("Measure loaded successfully, Measure details="+measure);
        return measure;
    }

    @Override
    public void updateMeasure(Measure measure) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(measure);
        logger.info("Measure updated successfully, Measure Details="+measure);
    }

}
