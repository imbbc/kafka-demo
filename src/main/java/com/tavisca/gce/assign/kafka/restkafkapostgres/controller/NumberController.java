package com.tavisca.gce.assign.kafka.restkafkapostgres.controller;

import com.tavisca.gce.assign.kafka.restkafkapostgres.model.Number;
import com.tavisca.gce.assign.kafka.restkafkapostgres.service.KafkaNumberSender;
import com.tavisca.gce.assign.kafka.restkafkapostgres.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/number")
public class NumberController {

    @Autowired
    NumberService numberService;

    @Autowired
    KafkaNumberSender kafkaSender;

    @PostMapping()
    String saveNumber(@RequestBody int number){
        kafkaSender.send(number);
        return "Number: " + number + " is saved.";
    }

    @GetMapping()
    List<Integer> getNumbers(){
        return numberService.findAll();
    }

    @GetMapping("/{id}")
    String getNumberById(@PathVariable(name = "id") long id){
        Optional<Integer> maybeValue = numberService.findById(id);
        return maybeValue.map(Object::toString).orElseGet(() -> "Value not present for id " + id);
    }
}
