package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone")
public class Phone implements Serializable {

    private Long phone_id;
    private Contact contact;

    @Id
    @Column(name = "phone_id")
    public Long getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(Long phone_id) {
        this.phone_id = phone_id;
    }

    @ManyToOne(targetEntity=Role.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
