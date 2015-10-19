package com.sivitsky.ddr.model;

import javax.persistence.*;

@Entity
@Table(name = "VALUTA")

public class Valuta {

    @Id
    @Column(name = "VALUTA_ID")
    @GeneratedValue
    private Integer valuta_id;

    @Column(name = "VALUTA_NAME")
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
