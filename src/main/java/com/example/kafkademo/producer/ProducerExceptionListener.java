package com.example.kafkademo.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

@Slf4j
public class ProducerExceptionListener<K, V> implements ProducerListener<K, V> {

    @Override
    public void onError(ProducerRecord<K, V> producerRecord, RecordMetadata recordMetadata, Exception exception) {
        log.info("Error {}, {}",recordMetadata.topic(), producerRecord.value() );
    }
}
