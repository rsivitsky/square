package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Role;
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
    public void addRole(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> listRole() {

        return sessionFactory.getCurrentSession().createQuery("from Role")
                .list();
    }

    @Override
    public void removeRole(Integer id) {
        Role role = (Role) sessionFactory.getCurrentSession().load(
                Role.class, id);
        if (null != role) {
            sessionFactory.getCurrentSession().delete(role);
        }

    }

    @Override
    public Role getRoleById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Role role = (Role) session.load(Role.class, new Integer(id));
        logger.info("Role loaded successfully, Role details="+role);
        return role;
    }

    @Override
    public void updateRole(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(role);
        logger.info("Role updated successfully, Role Details="+role);
    }

}
