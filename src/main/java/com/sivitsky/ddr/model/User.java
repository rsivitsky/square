package com.sivitsky.ddr.model;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

    @Id     @GeneratedValue
    @Column(name = "USER_ID")
    private Integer user_id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @ManyToOne
    @JoinColumn(name="VENDOR_ID_VENDOR")
    private Integer vendor_id_vendor;

    @ManyToOne
    @JoinColumn(name = "ROLE_ROLE_ID")
    private Integer role_role_id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getRole_role_id() {
        return role_role_id;
    }

    public void setRole_role_id(Integer role_role_id) {
        this.role_role_id = role_role_id;
    }

    public Integer getVendor_id_vendor() {
        return vendor_id_vendor;
    }

    public void setVendor_id_vendor(Integer vendor_id_vendor) {
        this.vendor_id_vendor = vendor_id_vendor;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

}
