package com.sivitsky.ddr.repository;

import com.sivitsky.ddr.model.Offer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OfferRepository extends PagingAndSortingRepository<Offer, Long> {
}
