package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Role;

import java.util.List;

public interface RoleDAO {

    public void addRole(Role role);

    public List<Role> listRole();

    public void removeRole(Integer id);

    public void updateRole(Role role);

    public Role getRoleById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
