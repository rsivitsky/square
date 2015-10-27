package com.sivitsky.ddr.repository;

import com.sivitsky.ddr.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("select u from User u")
    List<User> getAllUsers();
}
