package com.app.stream.producer.service;

import com.app.stream.producer.event.Event;
import com.app.stream.producer.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventService {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaEventService.class);

    @KafkaListener(topics = "products2",
            containerFactory = "kafkaListenerContainerFactory",
    groupId = "group_id")
    public void consumer(Event<Integer, Product> event){
        System.out.println("========EVENT==========");
        System.out.println(event);
        LOG.info("Message: {}", event);
    }
}
