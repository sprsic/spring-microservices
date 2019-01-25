package com.psdev.rentservice.service;

import com.psdev.rentservice.entity.User;
import com.psdev.rentservice.entity.model.UserModel;
import com.psdev.rentservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User saveUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setUserName(userModel.getUserName());
        return userRepository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> listAllUsers() {
        //todo needs paging
        return userRepository.findAll();
    }
}
