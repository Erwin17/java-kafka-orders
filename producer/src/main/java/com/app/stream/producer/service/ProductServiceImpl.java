package com.app.stream.producer.service;

import com.app.stream.producer.event.Event;
import com.app.stream.producer.model.Product;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService{

    private static final String topic = "products2";
    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public ProductServiceImpl(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        ProducerRecord<String, Event> message = new ProducerRecord(
                topic,
                new Event<>(
                Event.Type.CREATED,
                product.getId(),
                product));

        this.kafkaTemplate.send(message);
        return product;
    }
}
