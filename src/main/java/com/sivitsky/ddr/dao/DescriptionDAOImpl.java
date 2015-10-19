package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Description;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DescriptionDAOImpl implements DescriptionDAO {

    private static final Logger logger = LoggerFactory.getLogger(DescriptionDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addDescription(Description description) {
        sessionFactory.getCurrentSession().save(description);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Description> listDescription() {

        return sessionFactory.getCurrentSession().createQuery("from Description")
                .list();
    }

    @Override
    public void removeDescription(Integer id) {
        Description description = (Description) sessionFactory.getCurrentSession().load(
                Description.class, id);
        if (null != description) {
            sessionFactory.getCurrentSession().delete(description);
        }

    }

    @Override
    public Description getDescriptionById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Description description = (Description) session.load(Description.class, new Integer(id));
        logger.info("Description loaded successfully, Description details="+description);
        return description;
    }

    @Override
    public void updateDescription(Description description) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(description);
        logger.info("Description updated successfully, Description Details="+description);
    }

}
