package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> listRole();

    Role findById(Long id);

    List<Role> findAllWithDetail();

    void removeRole(Long id);

    Role saveRole(Role role);

    Role getRoleById(Long id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
