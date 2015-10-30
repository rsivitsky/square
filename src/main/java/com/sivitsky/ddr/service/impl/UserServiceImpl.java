package com.sivitsky.ddr.service.impl;

import com.sivitsky.ddr.model.User;
import com.sivitsky.ddr.repository.UserRepository;
import com.sivitsky.ddr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public List<User> listUsers() {
        return userRepository.getAllUsers();
    }

    @Transactional
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Transactional
    public void removeUser(Long id) {
        userRepository.delete(id);
    }
}
