package com.scotch.io.KafkaProducerConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);
	
   @KafkaListener(topics = "${default.topic.kafkaTopic}")
   public void listen(@Payload String message) {
       LOG.info("received message='{}'", message);
   }
}
