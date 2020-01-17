package com.tavisca.gce.assign.kafka.restkafkapostgres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaNumberSender {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.name}")
    private  String topicName;

    public void send(int number){
        kafkaTemplate.send(topicName, String.valueOf(number));
    }

}
