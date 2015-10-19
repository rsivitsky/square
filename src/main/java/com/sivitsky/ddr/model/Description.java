package com.sivitsky.ddr.model;

import javax.persistence.*;

@Entity
@Table(name = "DESCRIPTION")
public class Description {

    @Id
    @Column(name = "DESCRIPT_ID")
    @GeneratedValue
    private Integer descript_id;

    @Column(name = "DESCRIPT_NAME")
    private String descript_name;

    @Column(name = "SPECIFICATION_ID_SPEC")
    private Integer spec_id;

    @Column(name = "SPECIFICATION_TYPEOFSPEC_ID_TSPEC")
    private Integer typeofspec_id;

    @Column(name = "PART_ID_PART")
    private Integer part_id;

    @Column(name = "DESCRIPT_VALUE")
    private String descript_value;

    public Integer getDescript_id() {
        return descript_id;
    }

    public void setDescript_id(Integer descript_id) {
        this.descript_id = descript_id;
    }

    public String getDescript_name() {
        return descript_name;
    }

    public void setDescript_name(String descript_name) {
        this.descript_name = descript_name;
    }

    public Integer getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(Integer spec_id) {
        this.spec_id = spec_id;
    }

    public Integer getTypeofspec_id() {
        return typeofspec_id;
    }

    public void setTypeofspec_id(Integer typeofspec_id) {
        this.typeofspec_id = typeofspec_id;
    }

    public Integer getPart_id() {
        return part_id;
    }

    public void setPart_id(Integer part_id) {
        this.part_id = part_id;
    }

    public String getDescript_value() {
        return descript_value;
    }

    public void setDescript_value(String descript_value) {
        this.descript_value = descript_value;
    }

}
