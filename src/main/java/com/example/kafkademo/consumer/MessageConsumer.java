package com.example.kafkademo.consumer;

import com.example.kafkademo.avro.User;
import com.example.kafkademo.constants.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = KafkaConstants.SIMPLE_CASE_TOPIC)
    public void listen1(String message) {
        System.out.println("Received message: " + message);
    }

    @KafkaListener(topics = KafkaConstants.AVRO_CASE_TOPIC, containerFactory = "kafkaListenerContainerUserFactory")
    public void listen2(User user) {
        System.out.println("Received message: " + user.toString());
    }

}
