package com.example.kafkademo.mongo.model;

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
}
