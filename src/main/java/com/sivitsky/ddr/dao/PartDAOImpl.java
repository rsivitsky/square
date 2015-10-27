package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//@Repository
public class PartDAOImpl implements PartDAO {

    private static final Logger logger = LoggerFactory.getLogger(PartDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addPart(Part part) {
        sessionFactory.getCurrentSession().save(part);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Part> listPart() {

        return sessionFactory.getCurrentSession().createQuery("from Part")
                .list();
    }

    @Override
    public void removePart(Integer id) {
        Part part = (Part) sessionFactory.getCurrentSession().load(
                Part.class, id);
        if (null != part) {
            sessionFactory.getCurrentSession().delete(part);
        }

    }

    @Override
    public Part getPartById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Part part = (Part) session.load(Part.class, new Integer(id));
        logger.info("Part loaded successfully, Part details="+part);
        return part;
    }

    @Override
    public void updatePart(Part part) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(part);
        logger.info("Part updated successfully, Part Details="+part);
    }

}
