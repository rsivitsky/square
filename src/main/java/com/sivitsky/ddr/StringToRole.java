package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Role;
import com.sivitsky.ddr.service.RoleServiceImpl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("conversionService")
public class StringToRole implements Converter<String,Role> {

    RoleServiceImpl roleService;

    public Role convert(String id) {
        return roleService.getRoleByID(Long.valueOf(id));

    }
}