package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> listRoles();

    List<Role> listRoleWithoutAdmin();

    Role saveRole(Role role);

    Role getRoleById(Long id);

    void removeRole(Long id);
}
