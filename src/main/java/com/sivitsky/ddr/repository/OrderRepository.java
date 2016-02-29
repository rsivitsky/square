package com.sivitsky.ddr.repository;

import com.sivitsky.ddr.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
}
