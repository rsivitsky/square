package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Role;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private static final Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public Role saveRole(Role role) {
        sessionFactory.getCurrentSession().saveOrUpdate(role);
        logger.info("Role updated successfully, Role id=" + role.getRole_id());
        return role;
    }

    @SuppressWarnings("unchecked")
    public List<Role> listRoles() {
        return sessionFactory.getCurrentSession().createQuery("from Role").list();
    }

    public Role getRoleById(Long id) {
        return (Role) this.sessionFactory.getCurrentSession().get(Role.class, id);
    }

    public void removeRole(Long id) {
        Role role = (Role) sessionFactory.getCurrentSession().load(Role.class, id);
        if (null != role) {
            sessionFactory.getCurrentSession().delete(role);
        }
    }
}
