package com.sivitsky.ddr.repository;

import com.sivitsky.ddr.model.Vendor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface VendorRepository extends PagingAndSortingRepository<Vendor, Long> {

    @Query("select v from Vendor v")
    List<Vendor> getAllVendors();
}
