package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Description;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DescriptionDAOImpl implements DescriptionDAO {

    private static final Logger logger = LoggerFactory.getLogger(DescriptionDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public Description saveDescription(Description description) {
        sessionFactory.getCurrentSession().saveOrUpdate(description);
        logger.info("Description updated successfully, Description id=" + description.getDescript_id());
        return description;
    }

    @SuppressWarnings("unchecked")
    public List<Description> listDescription() {
        return sessionFactory.getCurrentSession().createQuery("from Description").list();
    }

    @SuppressWarnings("unchecked")
    public List<Description> listDescriptionByPartId(Long id) {
        return sessionFactory.getCurrentSession().createQuery("from Description where part_id= :part_id").setParameter("part_id", id).list();
    }

    public Description getDescriptionById(Long id) {
        return (Description) this.sessionFactory.getCurrentSession().get(Description.class, id);
    }

    public void removeDescription(Long id) {
        Description description = (Description) sessionFactory.getCurrentSession().load(Description.class, id);
        if (null != description) {
            sessionFactory.getCurrentSession().delete(description);
        }
    }

}
