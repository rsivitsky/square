package com.sivitsky.ddr.model;

import javax.persistence.*;

@Entity
@Table(name = "TYPEOFSPEC")
public class Typeofspec {

    @Id
    @Column(name = "TSPEC_ID")
    @GeneratedValue
    private Integer tspec_id;

    @Column(name = "TSPEC_NAME")
    private String tspec_name;

    public Integer getTspec_id() {
        return tspec_id;
    }

    public void setTspec_id(Integer tspec_id) {
        this.tspec_id = tspec_id;
    }

    public String getTspec_name() {
        return tspec_name;
    }

    public void setTspec_name(String tspec_name) {
        this.tspec_name = tspec_name;
    }
}
