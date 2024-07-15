package com.kipper.vendaservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SalesController {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public ResponseEntity<Void> create(@RequestBody String productId) {
    kafkaTemplate.send("stock", productId);
    return ResponseEntity.ok().build();
  }
}
