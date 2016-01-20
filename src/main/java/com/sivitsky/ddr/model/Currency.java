package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "valuta")
public class Currency implements Serializable {

    private Long valuta_id;
    private String valuta_name;
    private Set<Offer> offers = new HashSet<Offer>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "valuta_id")
    public Long getValuta_id() {
        return this.valuta_id;
    }

    public void setValuta_id(Long valuta_id) {
        this.valuta_id = valuta_id;
    }

    @Column(name = "valuta_name")
    public String getValuta_name() {
        return this.valuta_name;
    }

    public void setValuta_name(String valuta_name) {
        this.valuta_name = valuta_name;
    }

    @OneToMany(mappedBy = "currency", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Offer> getOffers() {
        return this.offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
