package com.example.kafkademo.controller;

import com.example.kafkademo.avro.User;
import com.example.kafkademo.constants.KafkaConstants;
import com.example.kafkademo.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private MessageProducer messageProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        messageProducer.sendMessage(message);
        return "Message sent: " + message;
    }

    @GetMapping("/sendUser")
    public String sendUser(@RequestParam("name") String name) {
        messageProducer.sendUserMessage(User.newBuilder().setName(name).build());
        return "Message sent: " + name;
    }

}