package com.psdev.rentservice.repository;

import com.psdev.rentservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    List<User> findAll();
}
