package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Specification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//@Repository
public class SpecificationDAOImpl implements SpecificationDAO {

    private static final Logger logger = LoggerFactory.getLogger(SpecificationDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addSpecification(Specification specification) {
        sessionFactory.getCurrentSession().save(specification);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Specification> listSpecification() {

        return sessionFactory.getCurrentSession().createQuery("from Specification")
                .list();
    }

    @Override
    public void removeSpecification(Integer id) {
        Specification specification = (Specification) sessionFactory.getCurrentSession().load(
                Specification.class, id);
        if (null != specification) {
            sessionFactory.getCurrentSession().delete(specification);
        }

    }

    @Override
    public Specification getSpecificationById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Specification specification = (Specification) session.load(Specification.class, new Integer(id));
        logger.info("Specification loaded successfully, Specification details="+specification);
        return specification;
    }

    @Override
    public void updateSpecification(Specification specification) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(specification);
        logger.info("Specification updated successfully, Specification Details="+specification);
    }

}
