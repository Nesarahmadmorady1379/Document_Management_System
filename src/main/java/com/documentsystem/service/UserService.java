package com.documentsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documentsystem.entity.User;
import com.documentsystem.repository.UserRepostory;

@Service
public class UserService {

    @Autowired
    private UserRepostory userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }
}

