package com.sivitsky.ddr.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Order implements Serializable {

    private Long booking_id;
    private Integer booking_num;
    private Date booking_date;
    private Offer offer;
    private User user;
    private Part part;

    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getOrder_id() {
        return booking_id;
    }

    public void setOrder_id(Long order_id) {
        this.booking_id = order_id;
    }

    @Column(name = "booking_num")
    public Integer getOrder_num() {return booking_num;
    }

    public void setOrder_num(Integer order_num) {
        this.booking_num = order_num;
    }

    @Column(name = "booking_date")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    public Date getOrder_date() {
        return booking_date;
    }

    public void setOrder_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    @ManyToOne(targetEntity=Offer.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "offer_id")
    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(targetEntity=Part.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "part_id")
    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
}
