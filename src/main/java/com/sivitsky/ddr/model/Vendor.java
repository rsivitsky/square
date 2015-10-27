package com.sivitsky.ddr.model;

import javax.persistence.*;

//поставщики товара
@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @Column(name = "vendor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer vendor_id;

    @Column(name = "vendor_name")
    private String vendor_name;

    public Integer getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(Integer vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }
}
