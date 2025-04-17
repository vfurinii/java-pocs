package org.vitorfurini.kafkapoc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vitorfurini.kafkapoc.producer.KafkaProducer;

@RestController
@RequestMapping("/api/v1/event")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/send")
    public ResponseEntity<String> sendEvent(@RequestBody String event) {
        kafkaProducer.sendEvent(event);
        return ResponseEntity.ok("Event sent");
    }

}
