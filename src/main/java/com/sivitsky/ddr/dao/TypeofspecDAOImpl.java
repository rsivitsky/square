package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Specification;
import com.sivitsky.ddr.model.Typeofspec;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeofspecDAOImpl implements TypeofspecDAO {

    private static final Logger logger = LoggerFactory.getLogger(TypeofspecDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addTypeofspec(Typeofspec typeofspec) {
        sessionFactory.getCurrentSession().save(typeofspec);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Typeofspec> listTypeofspec() {

        return sessionFactory.getCurrentSession().createQuery("from Typeofspec")
                .list();
    }

    @Override
    public void removeTypeofspec(Integer id) {
        Typeofspec typeofspec = (Typeofspec) sessionFactory.getCurrentSession().load(
                Typeofspec.class, id);
        if (null != typeofspec) {
            sessionFactory.getCurrentSession().delete(typeofspec);
        }

    }

    @Override
    public Typeofspec getTypeofspecById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Typeofspec typeofspec = (Typeofspec) session.load(Typeofspec.class, new Integer(id));
        logger.info("Typeofspec loaded successfully, Typeofspec details="+typeofspec);
        return typeofspec;
    }

    @Override
    public void updateTypeofspec(Typeofspec typeofspec) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(typeofspec);
        logger.info("Typeofspec updated successfully, Typeofspec Details="+typeofspec);
    }

}
