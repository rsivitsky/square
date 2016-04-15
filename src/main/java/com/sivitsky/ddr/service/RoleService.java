package com.sivitsky.ddr.service;

import java.util.List;

public interface RoleService {
    List<String> getRolesWithoutAdmin();

    List<String> getRoles();
}
