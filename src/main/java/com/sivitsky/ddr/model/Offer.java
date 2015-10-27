package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.util.Date;

//предложение товара конкретным поставщиком, (к примеру, с 01 января 15 г. Нетлайн предлагает память Кингстон за 10 долларов)
@Entity
@Table(name = "OFFER")
public class Offer {

    @Id
    @Column(name = "OFFER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer offer_id;

    @Column(name = "OFFER_DATE")
    private Date offer_date;

    @Column(name = "OFFER_COST")
    private Float offer_cost;

    @Column(name = "VALUTA_ID_VALUTA")
    private Integer valuta_id;

    @Column(name = "PART_ID_PART")
    private Integer part_id;

    @Column(name = "VENDOR_ID_VENDOR")
    private Integer vendor_id;

    public Integer getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(Integer offer_id) {
        this.offer_id = offer_id;
    }

    public Date getOffer_date() {
        return offer_date;
    }

    public void setOffer_date(Date offer_date) {
        this.offer_date = offer_date;
    }

    public Float getOffer_cost() {
        return offer_cost;
    }

    public void setOffer_cost(Float offer_cost) {
        this.offer_cost = offer_cost;
    }

    public Integer getValuta_id() {
        return valuta_id;
    }

    public void setValuta_id(Integer valuta_id) {
        this.valuta_id = valuta_id;
    }

    public Integer getPart_id() {
        return part_id;
    }

    public void setPart_id(Integer part_id) {
        this.part_id = part_id;
    }

    public Integer getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(Integer vendor_id) {
        this.vendor_id = vendor_id;
    }
}
