package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vendor")
public class Vendor implements Serializable {

    @Id
    @Column(name = "vendor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vendor_id;

    private String vendor_name;
    private String vendor_phone;
    private String vendor_email;
    private String vendor_addr;

    public Long getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(Long vendor_id) {
        this.vendor_id = vendor_id;
    }

    @Column(name = "vendor_name")
    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    @Column(name = "vendor_phone")
    public String getVendor_phone() {
        return vendor_phone;
    }

    public void setVendor_phone(String vendor_phone) {
        this.vendor_phone = vendor_phone;
    }

    @Column(name = "vendor_email")
    public String getVendor_email() {
        return vendor_email;
    }

    public void setVendor_email(String vendor_email) {
        this.vendor_email = vendor_email;
    }

    @Column(name = "vendor_addr")
    public String getVendor_addr() {
        return vendor_addr;
    }

    public void setVendor_addr(String vendor_addr) {
        this.vendor_addr = vendor_addr;
    }
}
