package com.BankingSystem.bankingsystem.service;

import org.springframework.stereotype.Service;

import com.BankingSystem.bankingsystem.model.User;
import com.BankingSystem.bankingsystem.repository.UserRepository;
import com.BankingSystem.bankingsystem.util.IdGenerator;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String email) {

        String userId = IdGenerator.generateUserId(); 

        User user = new User(userId, name, email);

        return userRepository.save(user);
    }

    public User getByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}
