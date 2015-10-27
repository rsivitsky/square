package com.sivitsky.ddr.model;

import javax.persistence.*;
import java.util.Date;

//заказ покупателя
@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer order_id;

    @Column(name = "ORDER_NUM")
    private Integer order_num;

    @Column(name = "ORDER_DATE")
    private Date order_date;

    @Column(name = "OFFER_ID_OFFER")
    private Integer offer_id;

    @Column(name = "OFFER_PART_ID_PART")
    private Integer part_id;

    @Column(name = "OFFER_VENDOR_ID_VENDOR")
    private Integer vendor_id;

    @Column(name = "USER_USER_ID")
    private Integer user_id;

    @Column(name = "USER_ROLE_ROLE_ID")
    private Integer role_id;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Integer getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(Integer offer_id) {
        this.offer_id = offer_id;
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
