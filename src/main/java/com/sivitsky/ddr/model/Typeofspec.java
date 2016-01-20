package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "typeofspec")
public class Typeofspec implements Serializable {

    private Long tspec_id;
    private String tspec_name;
    Set<Specification> specifications = new HashSet<Specification>();

    @Id
    @Column(name = "tspec_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getTspec_id() {
        return tspec_id;
    }

    public void setTspec_id(Long tspec_id) {
        this.tspec_id = tspec_id;
    }

    @Column(name = "tspec_name")
    public String getTspec_name() {
        return tspec_name;
    }

    public void setTspec_name(String tspec_name) {
        this.tspec_name = tspec_name;
    }

    @OneToMany(mappedBy = "typeofspec", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Set<Specification> specifications) {
        this.specifications = specifications;
    }
}
