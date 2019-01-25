package com.psdev.rentservice.resource;

import com.psdev.rentservice.entity.User;
import com.psdev.rentservice.entity.model.UserModel;
import com.psdev.rentservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveUser(@RequestBody UserModel userModel) {
        userService.saveUser(userModel);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<User> findByUsername(@RequestParam("username") String username) {
        User user = userService.findByUsername(username);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers(){
        List<User> users = userService.listAllUsers();
        return ResponseEntity.ok(users);
    }
}
