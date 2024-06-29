package com.stack.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stack.backend.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
