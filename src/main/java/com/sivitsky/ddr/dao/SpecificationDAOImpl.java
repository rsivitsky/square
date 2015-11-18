package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Role;
import com.sivitsky.ddr.model.Specification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecificationDAOImpl implements SpecificationDAO {

    private static final Logger logger = LoggerFactory.getLogger(SpecificationDAOImpl.class);
    private SessionFactory sessionFactory;

    @Autowired(required=true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Specification saveSpecification(Specification specification) {
        sessionFactory.getCurrentSession().saveOrUpdate(specification);
        logger.info("Specification updated successfully, Specification id=" + specification.getSpec_id());
        return specification;
    }

    @SuppressWarnings("unchecked")
    public List<Specification> listSpecification() {
        return sessionFactory.getCurrentSession().createQuery("from Specification").list();
    }

    public Specification getSpecificationById(Long id) {
        return (Specification) this.sessionFactory.getCurrentSession().get(Specification.class, id);
    }

    public void removeSpecification(Long id) {
        Specification specification = (Specification) sessionFactory.getCurrentSession().load(Specification.class, id);
        if (null != specification) {
            sessionFactory.getCurrentSession().delete(specification);
        }
    }
}
