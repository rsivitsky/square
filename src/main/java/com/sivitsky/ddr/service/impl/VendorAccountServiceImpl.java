package com.sivitsky.ddr.service.impl;

import com.sivitsky.ddr.model.User;
import com.sivitsky.ddr.model.Vendor;
import com.sivitsky.ddr.model.VendorAccount;
import com.sivitsky.ddr.repository.UserRepository;
import com.sivitsky.ddr.repository.VendorAccountRepository;
import com.sivitsky.ddr.repository.VendorRepository;
import com.sivitsky.ddr.service.VendorAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class VendorAccountServiceImpl implements VendorAccountService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private VendorAccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void addUserToVendor(Long vendorId, Long userId, VendorAccount.RoleType role) {
        Vendor vendor = vendorRepository.findOne(vendorId);
        if (vendor == null) {
            throw new EntityNotFoundException("Vendor not found: " + vendorId);
        }
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new EntityNotFoundException("User not found: " + userId);
        }

        VendorAccount account = accountRepository.findByUserAndVendor(vendorId, userId);
        if (account == null) {
            //Create new account
            account = new VendorAccount();
            account.setVendor(vendor);
            account.setUser(user);
            account.setRole(role);
        } else {
            account.setRole(role);
        }
        accountRepository.save(account);
    }
}
