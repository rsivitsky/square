package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Phone;
import com.sivitsky.ddr.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private static final Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public Role saveRole(Role role) {
        sessionFactory.getCurrentSession().saveOrUpdate(role);
        logger.info("Role saved successfully, Role id="+role.getRole_id());
        return role;
    }

    @SuppressWarnings("unchecked")
    public List<Role> listRole() {

        return sessionFactory.getCurrentSession().createQuery("from Role")
                .list();
    }

    public Role findById(Long id){
        return (Role)sessionFactory.getCurrentSession().getNamedQuery("Role.FindById").setParameter("id", id).uniqueResult();
    }

    public List<Role> findAllWithDetail(){
        return sessionFactory.getCurrentSession().getNamedQuery("Role.findAllWithDetail").list();
    }

    public void removeRole(Long id) {
        Role role = (Role) sessionFactory.getCurrentSession().load(
                Role.class, id);
        if (null != role) {
            sessionFactory.getCurrentSession().delete(role);
        }
    }

    public Role getRoleById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Role role = (Role) session.load(Role.class, new Long(id));
        logger.info("Role loaded successfully, Role details="+role);
        return role;
    }

}
