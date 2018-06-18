package com.scotch.io.POJOKafkaProducerConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {
	
	private final static Logger LOG = LoggerFactory.getLogger(KafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
   @Value("${default.topic.kafkaTopic}")
   private String topic;
   
	public void send(Object message) {
		LOG.info("sending message='{}' to topic='{}'", message, topic);
		Message<Object> finalMessage = MessageBuilder.withPayload(message).setHeader(KafkaHeaders.TOPIC, topic).build();
		kafkaTemplate.send(finalMessage);
	}
}
