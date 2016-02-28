package com.sivitsky.ddr.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "offer")
@NamedQueries({
        @NamedQuery(name = "Offer.getOffersByVendorId", query = "from Offer where vendor_id = :vendor_id"),
        @NamedQuery(name = "Offer.getOffersMaxAndMinPrice", query = "select part.part_id, part.part_name, min(offer.offer_price), max(offer.offer_price), count (offer.offer_id) as min_price from Offer offer join offer.part part " +
                "where part.part_id = :part_id and (:price_from=0.0f or offer.offer_price >= :price_from) and (:price_to=0.0f or offer.offer_price <= :price_to) " +
                "group by part.part_id"),
        @NamedQuery(name = "Offer.getOffersByPartId", query = "from Offer where part_id = :part_id and (:price_from=0.0f or offer_price > :price_from) " +
                "and (:price_to=0.0f or offer_price <= :price_to)"),
        @NamedQuery(name = "Offer.Detailed", query = "from Offer a left join fetch a.part b left join fetch b.descriptions c where a.offer_num > 0 and " +
                "(:mas_id is null or b.manufactur in (select distinct m from Manufactur m where m.manufactur_id in (:mas_id))) and " +
                "(:price_from is null or a.offer_price > :price_from) and (:price_to is null or a.offer_price < :price_to))")
}
)
public class Offer implements Serializable {

    @Id
    @Column(name = "offer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long offer_id;

    private Date offer_date;
    private Float offer_price;
    private Integer offer_num;
    private Float offer_sum;

    @ManyToOne(targetEntity = Vendor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne(targetEntity = Part.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "part_id")
    private Part part;

    @ManyToOne(targetEntity = Currency.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "valuta_id")
    private Currency currency;

    @OneToMany(mappedBy = "offer")
    private Set<Order> orders = new HashSet<Order>();

    public Long getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(Long offer_id) {
        this.offer_id = offer_id;
    }

    @Column(name = "offer_num")
    public Integer getOffer_num() {
        return offer_num;
    }

    public void setOffer_num(Integer offer_num) {
        this.offer_num = offer_num;
    }

    @Column(name = "offer_sum")
    public Float getOffer_sum() {
        return offer_sum;
    }

    public void setOffer_sum(Float offer_sum) {
        this.offer_sum = offer_sum;
    }

    @Column(name = "offer_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
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


    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }


    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }


    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }


    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
