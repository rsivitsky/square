package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable {

    private Long contact_id;
    private String contact_adr;
    private String contact_site;

    @Column(name = "vendor_id")
    private Integer vendor_id;

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

    public Integer getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(Integer vendor_id) {
        this.vendor_id = vendor_id;
    }

}
