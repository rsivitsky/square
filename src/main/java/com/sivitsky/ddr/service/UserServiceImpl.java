package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.UserDAOImpl;
import com.sivitsky.ddr.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAOImpl userDAO;

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
    public User getUserById(Long id) {
        return this.userDAO.getUserById(id);
    }

    @Transactional
    public void removeUser(Long id) {
        this.userDAO.removeUser(id);
    }

    @Autowired(required=true)
    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

}
