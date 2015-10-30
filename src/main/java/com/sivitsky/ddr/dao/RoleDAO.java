package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.VendorAccount;

import java.util.List;

public interface RoleDAO {

    void addRole(VendorAccount role);

    List<VendorAccount> listRole();

    void removeRole(Integer id);

    void updateRole(VendorAccount role);

    VendorAccount getRoleById(int id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
