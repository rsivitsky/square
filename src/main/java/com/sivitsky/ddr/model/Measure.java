package com.sivitsky.ddr.model;

import javax.persistence.*;

@Entity
@Table(name = "MEASURE")
public class Measure {

    @Id
    @Column(name = "MEASURE_ID")
    @GeneratedValue
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
