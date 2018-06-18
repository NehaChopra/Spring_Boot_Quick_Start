package com.scotch.io.POJOKafkaProducerConsumer.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;


@Configuration
public class KafkaProducerConfig {
	
	private final static Logger LOG = LoggerFactory.getLogger(KafkaProducerConfig.class);
   
	@Value("${spring.kafka.bootstrap-servers}")
   private String bootstrapServers;

   @Bean
   public Map<String, Object> producerConfigs() {
       Map<String, Object> props = new HashMap<>();
       props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
       props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
       props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
       return props;
   }
   
   @Bean
   public ProducerFactory<String, Object> producerFactory() {
       return new DefaultKafkaProducerFactory<>(producerConfigs());
   }
   
   @Bean
   public KafkaTemplate<String, Object> kafkaTemplate() {
       return new KafkaTemplate<>(producerFactory());
   }
	
}