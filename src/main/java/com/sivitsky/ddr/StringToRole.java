package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Role;
import com.sivitsky.ddr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class StringToRole implements Converter<String,Role> {

    private RoleService roleService;

    @Autowired(required=true)
    public void setRoleService(RoleService roleService)
    {
        this.roleService = roleService;
    }

    public Role convert(String id) {
        return this.roleService.getRoleByID(Long.valueOf(id));
    }
}