package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Role;

import java.util.List;

public interface RoleService {

    Role saveRole(Role role);

    List<Role> listRole();

    void removeRole(Long id);

    Role getRoleByID(Long id);

}
