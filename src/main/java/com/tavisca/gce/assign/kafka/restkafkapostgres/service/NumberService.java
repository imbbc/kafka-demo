package com.tavisca.gce.assign.kafka.restkafkapostgres.service;

import com.tavisca.gce.assign.kafka.restkafkapostgres.model.Number;
import com.tavisca.gce.assign.kafka.restkafkapostgres.repo.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NumberService {
    @Autowired
    NumberRepository numberRepository;

    public List<Integer> findAll() {
        return StreamSupport.stream(numberRepository.findAll().spliterator(), false)
                .map(Number::getValue)
                .collect(Collectors.toList());
    }

    public Optional<Integer> findById(long id) {
        return numberRepository.findById(id).map(Number::getValue);
    }

    public long save(int value) {
        Number number = numberRepository.save(new Number(value));
        return number.getId();
    }
}
