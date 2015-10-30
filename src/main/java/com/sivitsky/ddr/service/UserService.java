package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    List<User> listUsers();

    void removeUser(Long id);

    User getUserById(Long id);
}
