package com.sivitsky.ddr.model;

import javax.persistence.*;

@Entity
@Table(name = "SPECIFICATION")
public class Specification {

    @Id
    @Column(name = "SPEC_ID")
    @GeneratedValue
    private Integer spec_id;

    @Column(name = "SPEC_NAME")
    private String spec_name;

    @Column(name = "MEASURE_ID_MEASURE")
    private Integer measure_id;

    @Column(name = "TYPEOFSPEC_ID_TSPEC")
    private Integer typeofspec_id;

    public Integer getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(Integer spec_id) {
        this.spec_id = spec_id;
    }

    public String getSpec_name() {
        return spec_name;
    }

    public void setSpec_name(String spec_name) {
        this.spec_name = spec_name;
    }

    public Integer getMeasure_id() {
        return measure_id;
    }

    public void setMeasure_id(Integer measure_id) {
        this.measure_id = measure_id;
    }

    public Integer getTypeofspec_id() {
        return typeofspec_id;
    }

    public void setTypeofspec_id(Integer typeofspec_id) {
        this.typeofspec_id = typeofspec_id;
    }
}
