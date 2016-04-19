package com.sivitsky.ddr.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    private Long cart_id;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Cart() {
    }

    public Cart(Long cart_id) {
        this.cart_id = cart_id;
    }

    @Id
    @Column(name = "cart_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCart_id() {
        return cart_id;
    }

    public void setCart_id(Long cart_id) {
        this.cart_id = cart_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
