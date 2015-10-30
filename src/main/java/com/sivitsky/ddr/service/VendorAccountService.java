package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.VendorAccount;

public interface VendorAccountService {

    void addUserToVendor(Long vendorId, Long userId, VendorAccount.RoleType role);
}
