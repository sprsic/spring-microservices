package com.psdev.rentservice.service;

import com.psdev.rentservice.entity.User;
import com.psdev.rentservice.entity.model.UserModel;

import java.util.List;

public interface UserService {
    User saveUser(UserModel userModel);

    User findByUsername(String username);

    List<User> listAllUsers();
}
