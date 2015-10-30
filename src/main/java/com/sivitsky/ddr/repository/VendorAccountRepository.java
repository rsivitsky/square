package com.sivitsky.ddr.repository;

import com.sivitsky.ddr.model.VendorAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface VendorAccountRepository extends PagingAndSortingRepository<VendorAccount, Long> {

    @Query("SELECT a FROM VendorAccount AS a " +
            "WHERE a.user.id = :userId " +
            "AND a.vendor.id = :vendorId")
    VendorAccount findByUserAndVendor(@Param("vendorId") long vendorId, @Param("userId") long userId);
}
