package com.sivitsky.ddr.model;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue
    private Integer role_id;

    @Column(name = "ROLE_NAME")
    private String role_name;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
