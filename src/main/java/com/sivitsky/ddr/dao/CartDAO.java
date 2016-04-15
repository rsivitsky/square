package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.Cart;
import com.sivitsky.ddr.model.User;

public interface CartDAO {
    Cart saveCart(Cart cart);

    Cart getCartByUser(User user);

    void removeCart(Long id);
}
