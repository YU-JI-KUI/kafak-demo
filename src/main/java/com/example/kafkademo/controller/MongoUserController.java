package com.example.kafkademo.controller;

import com.example.kafkademo.mongo.model.MongoUser;
import com.example.kafkademo.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MongoUserController {

    @Autowired private UserService userService;

    @GetMapping("/findAllUsers")
    public List<MongoUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/removeAllUsers")
    public void removeAllUsers() {
        userService.removeAllUsers();
    }
}
