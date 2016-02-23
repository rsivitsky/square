package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.RoleDAO;
import com.sivitsky.ddr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Transactional
    public Role saveRole(Role role) {
        return roleDAO.saveRole(role);
    }

    @Transactional
    public List<Role> listRole() {
        return roleDAO.listRoles();
    }

    @Transactional
    public void removeRole(Long id) {
        roleDAO.removeRole(id);
    }

    @Transactional
    public Role getRoleByID(Long id) {
        return roleDAO.getRoleById(id);
    }
}
