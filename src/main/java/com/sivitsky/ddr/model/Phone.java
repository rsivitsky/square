package com.sivitsky.ddr.model;

import javax.persistence.*;

@Entity
@Table(name = "PHONE")
public class Phone {

    @Id
    @Column(name = "PHONE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer phone_id;

    @Column(name = "CONTACT_CONTACT_ID")
    private Integer contact_id;

    public Integer getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(Integer phone_id) {
        this.phone_id = phone_id;
    }

    public Integer getContact_id() {
        return contact_id;
    }

    public void setContact_id(Integer contact_id) {
        this.contact_id = contact_id;
    }
}
