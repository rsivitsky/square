package com.sivitsky.ddr.service;

import com.sivitsky.ddr.dao.UserDAOImpl;
import com.sivitsky.ddr.model.User;
import com.sivitsky.ddr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAOImpl userDAO;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        this.userDAO.updateUser(user);
    }

    @Transactional
    public List<User> listUsers() {
        List<User> users = new ArrayList<User>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    @Transactional
    public User getUserById(Integer id) {
        return this.userDAO.getUserById(id);
    }

    @Transactional
    public void removeUser(Integer id) {
        this.userDAO.removeUser(id);
    }
}
