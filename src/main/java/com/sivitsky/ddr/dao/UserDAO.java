package com.sivitsky.ddr.dao;

import com.sivitsky.ddr.model.User;

import java.util.List;

public interface UserDAO {

    public void addUser(User user);

    public List<User> listUsers();

    public void updateUser(User user);

    public User getUserById(int id);

    public void removeUser(Integer id);

    void setSessionFactory(org.hibernate.SessionFactory sessionFactory);
}
