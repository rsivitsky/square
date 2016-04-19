package com.sivitsky.ddr.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    @Size(min = 3, max = 20, message = "Login must be between 3 and 20 characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces")
    private String login;

    @Size(min = 6, max = 20, message = "The password must be at least 6 characters long.")
    private String password;

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Firstname must be alphanumeric with no spaces")
    @Size(min = 3, max = 50, message = "Your firstname must be between 3 and 50 characters long.")
    private String firstname;

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Lastname must be alphanumeric with no spaces")
    @Size(min = 3, max = 50, message = "Your lastname must be between 3 and 50 characters long.")
    private String lastname;

    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "Invalid email address.")
    private String email;

    private String role;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    public User() {
    }

    public User(String login, String password, String firstname, String lastname) {
        this.login = login;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }
/*
    public User(Long user_id) {
        this.user_id = user_id;
    }*/

    public Long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Column(name = "login")
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "password")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "firstname")
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "lastname")
    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "role")
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return ((firstname != null) ? firstname : "-") + " " + ((lastname != null) ? lastname : "-");
    }

}
