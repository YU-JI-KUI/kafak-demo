package com.example.kafkademo.mongo.adapter;

import com.example.kafkademo.avro.User;
import com.example.kafkademo.mongo.model.UserDto;
import org.springframework.beans.BeanUtils;

public class AvroUserAdapter {

    private final User user;

    public AvroUserAdapter(User user) {
        this.user = user;
    }

    public UserDto toUserDto() {
        var userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

}
