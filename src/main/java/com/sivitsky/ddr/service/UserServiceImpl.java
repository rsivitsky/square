package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.UserDAO;
import com.sivitsky.ddr.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Transactional
    public void addUser(User user) {
        this.userDAO.addUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        this.userDAO.updateUser(user);
    }

    @Transactional
    public List<User> listUsers() {

        return this.userDAO.listUsers();
    }

    @Transactional
    public User getUserById(Integer id) {
        return this.userDAO.getUserById(id);
    }

    @Transactional
    public void removeUser(Integer id) {
        this.userDAO.removeUser(id);
    }

    public void setUserDAO(com.sivitsky.ddr.dao.UserDAOImpl userDAO) {
    }
}
