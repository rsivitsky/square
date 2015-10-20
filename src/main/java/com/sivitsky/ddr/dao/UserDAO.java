package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    List<User> listUsers();

    void updateUser(User user);

    User getUserById(int id);

    void removeUser(Integer id);
}
