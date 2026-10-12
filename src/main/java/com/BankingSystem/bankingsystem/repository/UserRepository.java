package com.BankingSystem.bankingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.BankingSystem.bankingsystem.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(String userId);

    boolean existsByUserId(String userId);
}
