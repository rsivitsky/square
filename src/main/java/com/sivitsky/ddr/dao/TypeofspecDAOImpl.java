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

    public Typeofspec saveTypeofspec(Typeofspec typeofspec) {
        sessionFactory.getCurrentSession().saveOrUpdate(typeofspec);
        logger.info("Typeofspec updated successfully, Typeofspec id=" + typeofspec.getTspec_id());
        return typeofspec;
    }

    @SuppressWarnings("unchecked")
    public List<Typeofspec> listTypeofspecs() {
        return sessionFactory.getCurrentSession().createQuery("from typeofspec").list();
    }

    public Typeofspec getTypeofspecById(Long id) {
        return (Typeofspec) this.sessionFactory.getCurrentSession().get(Typeofspec.class, id);
    }

    public void removeTypeofspec(Long id) {
        Typeofspec typeofspec = (Typeofspec) sessionFactory.getCurrentSession().load(Typeofspec.class, id);
        if (null != typeofspec) {
            sessionFactory.getCurrentSession().delete(typeofspec);
        }
    }

    @Autowired(required=true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
