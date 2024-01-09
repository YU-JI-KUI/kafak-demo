package com.example.kafkademo.mongo.service;

import com.example.kafkademo.avro.User;
import com.example.kafkademo.mongo.model.MongoUser;
import com.example.kafkademo.mongo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired private UserRepo userRepo;

    public void saveUser(User user) {
        var mongoUser = new MongoUser();
        mongoUser.setId(user.getId());
        mongoUser.setName(user.getName());
        mongoUser.setAge(user.getAge());
        mongoUser.setRemake(user.getRemark());
        userRepo.save(mongoUser);
    }

    public List<MongoUser> getAllUsers() {
        return userRepo.findAll();
    }

}
