package com.scotch.io.POJOKafkaProducerConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {
	
	private final static Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);
	
   @KafkaListener(topics = "${default.topic.kafkaTopic}")
   public void listen(@Payload Object message, @Headers MessageHeaders headers) {
       LOG.info("received message='{}'", message);
       
       headers.keySet().forEach(key -> {
      	 LOG.info("{}: {}", key, headers.get(key));
       });
   }
}
