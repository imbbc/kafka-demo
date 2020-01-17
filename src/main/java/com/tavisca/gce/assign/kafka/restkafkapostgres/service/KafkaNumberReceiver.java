package com.tavisca.gce.assign.kafka.restkafkapostgres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaNumberReceiver {

    @Autowired
    NumberService numberService;

    @KafkaListener(topics = "${topic.number}")
    void listen(String message) {
        int value = Integer.parseInt(message);
        numberService.save(value + 1);
    }
}
