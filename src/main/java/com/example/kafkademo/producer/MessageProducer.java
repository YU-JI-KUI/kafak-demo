package com.example.kafkademo.producer;

import com.example.kafkademo.avro.User;
import com.example.kafkademo.constants.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, User> userKafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send(KafkaConstants.SIMPLE_CASE_TOPIC, message);
    }

    public void sendUserMessage(User user) {
        userKafkaTemplate.send(KafkaConstants.AVRO_CASE_TOPIC, user);
    }

}
