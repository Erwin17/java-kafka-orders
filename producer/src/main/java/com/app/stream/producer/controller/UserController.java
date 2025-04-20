package com.app.stream.producer.controller;

import com.app.stream.producer.config.Event;
import com.app.stream.producer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
public class UserController {

    private final KafkaTemplate<String, Event<Integer, User>> kafkaTemplate;

    @Autowired
    public UserController(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping(value = "/greeting", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greeting(){
        return "All Good";
    }

    @PostMapping(value="/user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody User user){
        this.kafkaTemplate.send("products", user.getId().toString(),  new Event<>(Event.Type.CREATED, user.getId(), user));
        return ResponseEntity.accepted().build();
    }


}
