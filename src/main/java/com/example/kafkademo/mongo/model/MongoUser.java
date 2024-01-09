package com.example.kafkademo.mongo.model;

import com.example.kafkademo.avro.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class MongoUser {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String remake;

    private UserAddress address;
    private UserDto user;
}
