package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable {

    private Long contact_id;
    private String contact_adr;
    private String contact_site;
    private Vendor vendor;
    private Set<Phone> phones = new HashSet<Phone>();

    @Id
    @Column(name = "contact_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getContact_id() {
        return contact_id;
    }

    public void setContact_id(Long contact_id) {
        this.contact_id = contact_id;
    }

    @Column(name = "contact_adr")
    public String getContact_adr() {
        return contact_adr;
    }

    public void setContact_adr(String contact_adr) {
        this.contact_adr = contact_adr;
    }

    @Column(name = "contact_site")
    public String getContact_site() {
        return contact_site;
    }

    public void setContact_site(String contact_site) {
        this.contact_site = contact_site;
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="vendor_id")
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
