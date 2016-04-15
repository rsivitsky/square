package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "measure")
public class Measure implements Serializable {

    private Long measure_id;
    private String measure_name;

    @Id
    @Column(name = "measure_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getMeasure_id() {
        return measure_id;
    }

    public void setMeasure_id(Long measure_id) {
        this.measure_id = measure_id;
    }

    @Column(name = "measure_name")
    public String getMeasure_name() {
        return measure_name;
    }

    public void setMeasure_name(String measure_name) {
        this.measure_name = measure_name;
    }

}
