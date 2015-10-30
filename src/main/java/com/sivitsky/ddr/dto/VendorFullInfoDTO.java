package com.sivitsky.ddr.dto;

import java.util.ArrayList;
import java.util.List;

public class VendorFullInfoDTO {
    private Long id;
    private String name;
    private List<VendorAccountInfoDTO> accounts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VendorAccountInfoDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<VendorAccountInfoDTO> accounts) {
        this.accounts = accounts;
    }
}
