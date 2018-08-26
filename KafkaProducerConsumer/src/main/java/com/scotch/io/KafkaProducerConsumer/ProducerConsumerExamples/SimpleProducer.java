package com.scotch.io.KafkaProducerConsumer.ProducerConsumerExamples;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SimpleProducer {
	public static void main(String []args) {
		String topicName = "SimpleTopic";
		String key = "key";
		String value = "value";
		
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092, localhost:9093");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		Producer<String, String> producer = new KafkaProducer<>(properties);
		ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);
		/*
		 * Fire and forget 
		 * where messages are fired to broker and we are not waiting for ack from broker end.
		 * In expectation that kafka is fault tolerant machine where most of the messages will be
		 * send to kafka, if there is an error retry would be done in case of recoverable error.
		 * Loosing a message in case of kafka would be thin.
		 * 
		 * Counting hits on videos, collecting the twitter data for sentimental analysis.
		 * 
		 */
		producer.send(record);
		producer.close();
		
	}
}
