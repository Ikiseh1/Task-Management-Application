package com.ikiseh.My_Task_Management_System.repository;

import com.ikiseh.My_Task_Management_System.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
