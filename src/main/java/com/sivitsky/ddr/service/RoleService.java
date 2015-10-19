package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Role;

import java.util.List;

public interface RoleService {

    public void addRole(Role role);

    public List<Role> listRole();

    public void removeRole(Integer id);

}
