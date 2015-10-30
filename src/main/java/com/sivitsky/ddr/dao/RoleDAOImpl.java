package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.VendorAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//@Repository
public class RoleDAOImpl implements RoleDAO {

    private static final Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addRole(VendorAccount role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<VendorAccount> listRole() {

        return sessionFactory.getCurrentSession().createQuery("from VendorAccount")
                .list();
    }

    @Override
    public void removeRole(Integer id) {
        VendorAccount role = (VendorAccount) sessionFactory.getCurrentSession().load(
                VendorAccount.class, id);
        if (null != role) {
            sessionFactory.getCurrentSession().delete(role);
        }

    }

    @Override
    public VendorAccount getRoleById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        VendorAccount role = (VendorAccount) session.load(VendorAccount.class, new Integer(id));
        logger.info("Role loaded successfully, Role details="+role);
        return role;
    }

    @Override
    public void updateRole(VendorAccount role) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(role);
        logger.info("Role updated successfully, Role Details="+role);
    }

}
