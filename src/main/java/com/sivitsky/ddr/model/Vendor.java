package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vendor")
public class Vendor implements Serializable {

    @Id
    @Column(name = "vendor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vendor_id;

    @Column(name = "vendor_name")
    private String vendor_name;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users = new HashSet<User>();

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Offer> offers = new HashSet<Offer>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vendor")
    private Contact contact;

    public Long getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(Long vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
