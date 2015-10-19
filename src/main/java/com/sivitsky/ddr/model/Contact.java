package com.sivitsky.ddr.model;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT")
public class Contact {

    @Id
    @Column(name = "CONTACT_ID")
    @GeneratedValue
    private Integer contact_id;

    @Column(name = "CONTACT_ADR")
    private String contact_adr;

    @Column(name = "CONTACT_SITE")
    private String contact_site;

    @Column(name = "VENDOR_ID_VENDOR")
    private Integer vendor_id;

    public Integer getContact_id() {
        return contact_id;
    }

    public void setContact_id(Integer contact_id) {
        this.contact_id = contact_id;
    }

    public String getContact_adr() {
        return contact_adr;
    }

    public void setContact_adr(String contact_adr) {
        this.contact_adr = contact_adr;
    }

    public String getContact_site() {
        return contact_site;
    }

    public void setContact_site(String contact_site) {
        this.contact_site = contact_site;
    }

    public Integer getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(Integer vendor_id) {
        this.vendor_id = vendor_id;
    }

}
