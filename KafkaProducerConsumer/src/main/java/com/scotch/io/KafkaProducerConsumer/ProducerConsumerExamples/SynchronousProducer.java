package com.scotch.io.KafkaProducerConsumer.ProducerConsumerExamples;

import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class SynchronousProducer {

	public static void main(String[] args) {
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
		 * Synchronous send
		 * Waiting for ack, less throughtput is achieved.
		 * Latency in ack.
		 */
		try {
			Future<RecordMetadata> ack = producer.send(record);
			RecordMetadata metaData = ack.get();
			
			System.out.println("Message is sent to Partition no " + metaData.partition() + " and offset " + metaData.offset());
			 System.out.println("SynchronousProducer Completed with success.");
		}catch(Exception e) {
			 e.printStackTrace();
          System.out.println("SynchronousProducer failed with an exception");
		}finally {
			producer.close();
		}
	}
}

