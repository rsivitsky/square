package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.RoleDAO;
import com.sivitsky.ddr.model.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    //    @Autowired
    private RoleDAO roleDAO;

    @Transactional
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }

    @Transactional
    public List<Role> listRole() {

        return roleDAO.listRole();
    }

    @Transactional
    public void removeRole(Integer id) {
        roleDAO.removeRole(id);
    }
}
