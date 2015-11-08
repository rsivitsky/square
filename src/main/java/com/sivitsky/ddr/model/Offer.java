package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OFFER")
public class Offer {

    private Long offer_id;
    private Date offer_date;
    private Float offer_cost;
    private Integer valuta_id;
    private Integer part_id;
    private Vendor vendor;
    private Part part;
    private Currency currency;

    @Id
    @Column(name = "offer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(Long offer_id) {
        this.offer_id = offer_id;
    }

    @Column(name = "offer_date")
    public Date getOffer_date() {
        return offer_date;
    }

    public void setOffer_date(Date offer_date) {
        this.offer_date = offer_date;
    }

    @Column(name = "offer_cost")
    public Float getOffer_cost() {
        return offer_cost;
    }

    public void setOffer_cost(Float offer_cost) {
        this.offer_cost = offer_cost;
    }

    @Column(name = "valuta_id")
    public Integer getValuta_id() {
        return valuta_id;
    }

    public void setValuta_id(Integer valuta_id) {
        this.valuta_id = valuta_id;
    }

    @Column(name = "part_id")
    public Integer getPart_id() {
        return part_id;
    }

    public void setPart_id(Integer part_id) {
        this.part_id = part_id;
    }

    @ManyToOne(targetEntity=Vendor.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "vendor_id")
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @ManyToOne(targetEntity=Vendor.class, fetch=FetchType.EAGER)
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
}
