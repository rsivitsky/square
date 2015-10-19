package com.sivitsky.ddr.model;

import javax.persistence.*;

@Entity
@Table(name = "PART")
public class Part {

    @Id
    @Column(name = "PART_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer part_id;

    @Column(name = "PART_NAME")
    private String part_name;

    public Integer getPart_id() {
        return part_id;
    }

    public void setPart_id(Integer part_id) {
        this.part_id = part_id;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }
}
