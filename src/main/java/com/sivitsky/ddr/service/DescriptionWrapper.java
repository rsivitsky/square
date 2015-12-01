package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Description;

import java.util.List;

public class DescriptionWrapper {

    private List<Description> descriptionList = null;

    public DescriptionWrapper(List<Description> descriptionList) {
        this.descriptionList = descriptionList;
    }

    public List<Description> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(List<Description> descriptionList) {
        this.descriptionList = descriptionList;
    }
}
