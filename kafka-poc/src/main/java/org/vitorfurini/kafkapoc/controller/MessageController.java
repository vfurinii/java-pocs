package org.vitorfurini.kafkapoc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vitorfurini.kafkapoc.model.EventUser;
import org.vitorfurini.kafkapoc.producer.KafkaProducer;
import org.vitorfurini.kafkapoc.util.JwtUtil;

@RestController
@RequestMapping("/api/v1/event")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEvent(@RequestBody EventUser event) {
        kafkaProducer.sendEvent(event);
        return ResponseEntity.ok("Event sent");
    }

}
