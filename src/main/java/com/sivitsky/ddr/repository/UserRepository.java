package com.sivitsky.ddr.repository;

import com.sivitsky.ddr.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByEmail(String email);
}
