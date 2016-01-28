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
    public User saveUser(User user) {
        return this.userDAO.saveUser(user);
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
    public User getUserByName(String name) {
        return this.userDAO.getUserByName(name);
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
