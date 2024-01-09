package com.example.kafkademo.consumer;

import com.example.kafkademo.avro.User;
import com.example.kafkademo.constants.KafkaConstants;
import com.example.kafkademo.mongo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageConsumer {

    @Autowired private UserService userService;

    @KafkaListener(topics = KafkaConstants.SIMPLE_CASE_TOPIC)
    public void listen1(String message) {
        log.info("{}  Received message: {}", KafkaConstants.GROUP_T1_DEFAULT, message);
    }

    @KafkaListener(topics = KafkaConstants.AVRO_CASE_TOPIC, containerFactory = "kafkaListenerContainerUserFactory")
    public void listen2(User user) {
        log.info("{}  Received message: {}", KafkaConstants.GROUP_T2_DEFAULT, user);
    }

    @KafkaListener(topics = KafkaConstants.AVRO_CASE_TOPIC, containerFactory = "kafkaListenerContainerUserFactory", groupId = KafkaConstants.GROUP_T2_G2)
    public void listen3(User user) {
        log.info("{}  Received message: {}", KafkaConstants.GROUP_T2_G2, user);
        userService.saveUser(user);
        log.info("user saved into Mongo database ");
    }

}
