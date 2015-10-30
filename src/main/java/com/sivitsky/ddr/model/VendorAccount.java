package com.sivitsky.ddr.model;

import javax.persistence.*;

//роли пользователей в приложении, к примеру администратор, пользователь, менеджер
@Entity
@Table(name = "vendor_account")
public class VendorAccount extends ManagedEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendor_fk", nullable = false)
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_fk", nullable = false)
    private User user;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleType role;

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public enum RoleType {
        ADMIN,
        MANAGER
    }
}
