package com.sivitsky.ddr.repository;

import com.sivitsky.ddr.model.Vendor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VendorRepository extends PagingAndSortingRepository<Vendor, Long> {
}
