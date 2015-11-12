package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "part")
@NamedQueries(
        @NamedQuery(name="Part.findAllWithDetail", query="select distinct c from Part c left join fetch c.descriptions t" )
)
public class Part {

    private Long part_id;
    private String part_name;
    private Set<Offer> offers = new HashSet<Offer>();
    private Set<Description> descriptions = new HashSet<Description>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    public Long getPart_id() {
        return part_id;
    }

    public void setPart_id(Long part_id) {
        this.part_id = part_id;
    }

    @Column(name = "part_name")
    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Set<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public void addDescriptions(Description description)
    {
        description.setPart(this);
        getDescriptions().add(description);
    }

    public void removeDescriptions(Description description)
    {
        getDescriptions().remove(description);
    }
}
