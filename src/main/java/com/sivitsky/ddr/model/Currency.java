package com.sivitsky.ddr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//Валюты
@Entity
@Table(name = "currency")
public class Currency extends ManagedEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
