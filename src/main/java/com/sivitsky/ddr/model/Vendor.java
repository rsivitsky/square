package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//поставщики товара
@Entity
@Table(name = "vendor")
public class Vendor extends ManagedEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "vendor", fetch = FetchType.EAGER)
    private List<VendorAccount> accounts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VendorAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<VendorAccount> accounts) {
        this.accounts = accounts;
    }
}
