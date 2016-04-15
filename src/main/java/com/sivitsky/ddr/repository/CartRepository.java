package com.sivitsky.ddr.repository;

import com.sivitsky.ddr.model.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {
}
