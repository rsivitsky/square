package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Role;

import java.util.List;

public interface RoleDAO {

    void addRole(Role role);

    List<Role> listRole();

    void removeRole(Integer id);

    void updateRole(Role role);

    Role getRoleById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
