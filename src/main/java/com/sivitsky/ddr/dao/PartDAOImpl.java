package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Order;
import com.sivitsky.ddr.model.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PartDAOImpl implements PartDAO {

    private static final Logger logger = LoggerFactory.getLogger(PartDAOImpl.class);
    private SessionFactory sessionFactory;

    @Autowired(required=true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Part savePart(Part part) {
        sessionFactory.getCurrentSession().saveOrUpdate(part);
        logger.info("Part updated successfully, Part id=" + part.getPart_id());
        return part;
    }

    @SuppressWarnings("unchecked")
    public List<Part> listPart() {
        return sessionFactory.getCurrentSession().createQuery("from Part").list();
    }

    public Part getPartById(Long id) {
        return (Part) this.sessionFactory.getCurrentSession().get(Part.class, id);
    }

    public void removePart(Long id) {
        Part part = (Part) sessionFactory.getCurrentSession().load(Part.class, id);
        if (null != part) {
            sessionFactory.getCurrentSession().delete(part);
        }
    }

}
