package com.example.kafkademo.mongo.repo;

import com.example.kafkademo.mongo.model.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<MongoUser, String> {
}
