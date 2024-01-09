package com.example.kafkademo.mongo.model;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String name;
    private int age;
    private String remark;
}
