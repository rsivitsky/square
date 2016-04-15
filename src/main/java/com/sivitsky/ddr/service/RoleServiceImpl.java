package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.ListRole;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    public List<String> getRolesWithoutAdmin() {
        List<String> listRoles = new ArrayList<String>();
        listRoles.add(ListRole.ROLE_VENDOR.toString());
        listRoles.add(ListRole.ROLE_USER.toString());
        return listRoles;
    }

    public List<String> getRoles() {
        List<String> listRoles = new ArrayList<String>();
        listRoles.add(ListRole.ROLE_ADMIN.toString());
        listRoles.add(ListRole.ROLE_VENDOR.toString());
        listRoles.add(ListRole.ROLE_USER.toString());
        return listRoles;
    }
}
