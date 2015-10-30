package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    List<User> listUsers();

    void updateUser(User user);

    User getUserById(Long id);

    void removeUser(Long id);
}
