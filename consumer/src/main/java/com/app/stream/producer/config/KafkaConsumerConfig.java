package com.app.stream.producer.config;

import com.app.stream.producer.event.Event;
import com.app.stream.producer.model.Product;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    private final String bootstrapAddress = "localhost:9092";

    @Bean
    public ConsumerFactory<String, Event<Integer, Product>> consumerFactory(){
        final JsonDeserializer<Event<Integer, Product>> deserializer = new JsonDeserializer<>(Event.class);

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id_1"); // opcional, pero necesario
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "lector-particion-especifica");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Event<Integer, Product>> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Event<Integer, Product>> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
