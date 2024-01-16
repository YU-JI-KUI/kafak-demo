package com.example.kafkademo.mongo.repo;

import com.example.kafkademo.exception.ErrorResponseDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ErrorResponseRepo extends MongoRepository<ErrorResponseDocument, String> {
}
