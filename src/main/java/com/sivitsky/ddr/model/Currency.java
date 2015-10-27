package com.sivitsky.ddr.model;

import javax.persistence.*;

//Валюты
@Entity
@Table(name = "valuta")
public class Currency {

    @Id
    @Column(name = "valuta_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer valuta_id;

    @Column(name = "valuta_name")
    private String valuta_name;

    public Integer getValuta_id() {
        return valuta_id;
    }

    public void setValuta_id(Integer valuta_id) {
        this.valuta_id = valuta_id;
    }

    public String getValuta_name() {
        return valuta_name;
    }

    public void setValuta_name(String valuta_name) {
        this.valuta_name = valuta_name;
    }

}
