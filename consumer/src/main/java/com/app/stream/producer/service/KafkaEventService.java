package com.app.stream.producer.service;

import com.app.stream.producer.config.Event;
import com.app.stream.producer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventService {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaEventService.class);

    @KafkaListener(topics = "products",
    containerFactory = "kafkaListenerContainerFactory",
    groupId = "group_id")
    public void consumer(Event<Integer, User> event){
        System.out.println("========EVENT==========");
        System.out.println(event.getData());
        LOG.info("Message: {}", event);
    }
}
