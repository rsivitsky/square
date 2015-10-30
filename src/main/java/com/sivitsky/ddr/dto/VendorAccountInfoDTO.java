package com.sivitsky.ddr.dto;

import com.sivitsky.ddr.model.VendorAccount;

public class VendorAccountInfoDTO {
    private Long userId;
    private String name;
    private VendorAccount.RoleType role;

    public VendorAccountInfoDTO() {
    }

    public VendorAccountInfoDTO(Long userId, String name, VendorAccount.RoleType role) {
        this.userId = userId;
        this.name = name;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VendorAccount.RoleType getRole() {
        return role;
    }

    public void setRole(VendorAccount.RoleType role) {
        this.role = role;
    }
}
