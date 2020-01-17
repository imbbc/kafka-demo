package com.tavisca.gce.assign.kafka.restkafkapostgres.repo;

import com.tavisca.gce.assign.kafka.restkafkapostgres.model.Number;
import org.springframework.data.repository.CrudRepository;

public interface NumberRepository extends CrudRepository<Number, Long> {

}
