package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specification")
public class Specification {

    private Long spec_id;
    private String spec_name;
    private Set<Description> descriptions = new HashSet<Description>();
    private Typeofspec typeofspec;
    private Measure measure;

    @Id
    @Column(name = "spec_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(Long spec_id) {
        this.spec_id = spec_id;
    }

    @Column(name = "spec_name")
    public String getSpec_name() {
        return spec_name;
    }

    public void setSpec_name(String spec_name) {
        this.spec_name = spec_name;
    }

    @OneToMany(mappedBy = "specification", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    public Set<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Set<Description> descriptions) {
        this.descriptions = descriptions;
    }

    @ManyToOne(targetEntity=Typeofspec.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "tspec_id")
    public Typeofspec getTypeofspec() {
        return typeofspec;
    }

    public void setTypeofspec(Typeofspec typeofspec) {
        this.typeofspec = typeofspec;
    }

    @ManyToOne(targetEntity=Measure.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "measure_id")
    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
}
