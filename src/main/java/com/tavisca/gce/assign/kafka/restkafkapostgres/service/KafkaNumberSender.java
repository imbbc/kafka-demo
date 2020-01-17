package com.tavisca.gce.assign.kafka.restkafkapostgres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaNumberSender {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.number}")
    private  String numberTopic;

    public void send(int number){
        kafkaTemplate.send(numberTopic, String.valueOf(number));
    }

}
