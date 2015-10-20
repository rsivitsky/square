package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    List<Role> listRole();

    void removeRole(Integer id);

}
