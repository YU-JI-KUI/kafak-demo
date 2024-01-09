package com.example.kafkademo.mongo.service;

import com.example.kafkademo.avro.User;
import com.example.kafkademo.mongo.adapter.AvroUserAdapter;
import com.example.kafkademo.mongo.model.MongoUser;
import com.example.kafkademo.mongo.model.UserAddress;
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

        // 测试关联对象的存储，mock 一个 user address
        var address = new UserAddress();
        address.setCity("Shanghai");
        address.setAddress("Pu Dong Da Dao");

        mongoUser.setAddress(address);

        var userAdapter = new AvroUserAdapter(user);
        mongoUser.setUser(userAdapter.toUserDto());

        userRepo.save(mongoUser);
    }

    public List<MongoUser> getAllUsers() {
        return userRepo.findAll();
    }

    public void removeAllUsers() {
        userRepo.deleteAll();
    }

}
