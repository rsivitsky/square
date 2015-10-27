package com.sivitsky.ddr.model;

import javax.persistence.*;

//единицы измерения, к примеру Kb, Gb, штуки и так далее
@Entity
@Table(name = "MEASURE")
public class Measure {

    @Id
    @Column(name = "MEASURE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer measure_id;

    @Column(name = "MEASURE_NAME")
    private String measure_name;

    public Integer getMeasure_id() {
        return measure_id;
    }

    public void setMeasure_id(Integer measure_id) {
        this.measure_id = measure_id;
    }

    public String getMeasure_name() {
        return measure_name;
    }

    public void setMeasure_name(String measure_name) {
        this.measure_name = measure_name;
    }
}
