package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "offer")
@NamedQueries({
       // @NamedQuery(name="Offer.allFiltersForOrders", query="select distinct c from Offer c left join fetch c.part t" ),
        @NamedQuery(name="Offer.getOffersByVendorId", query="from Offer where vendor_id = :vendor_id" )
}
)
public class Offer implements Serializable {

    private Long offer_id;
    private Date offer_date;
    private Float offer_price;
    private Integer offer_num;
    private Float offer_sum;
    private Vendor vendor;
    private Part part;
    private Currency currency;
    private Set<Order> orders = new HashSet<Order>();

    @Id
    @Column(name = "offer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(Long offer_id) {
        this.offer_id = offer_id;
    }

    @Column(name="offer_num")
    public Integer getOffer_num() {
        return offer_num;
    }

    public void setOffer_num(Integer offer_num) {
        this.offer_num = offer_num;
    }

    @Column(name="offer_sum")
    public Float getOffer_sum() {
        return offer_sum;
    }

    public void setOffer_sum(Float offer_sum) {
        this.offer_sum = offer_sum;
    }

    @Column(name = "offer_date")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    public Date getOffer_date() {
        return offer_date;
    }

    public void setOffer_date(Date offer_date) {
        this.offer_date = offer_date;
    }

    @Column(name = "offer_price")
    public Float getOffer_price() {
        return offer_price;
    }

    public void setOffer_price(Float offer_price) {
        this.offer_price = offer_price;
    }

    @ManyToOne(targetEntity=Vendor.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "vendor_id")
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @ManyToOne(targetEntity=Part.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "part_id")
    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    @ManyToOne(targetEntity=Currency.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "valuta_id")
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
