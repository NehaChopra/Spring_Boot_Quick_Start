package com.scotch.io.KafkaProducerConsumer.ProducerConsumerExamples;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.util.ObjectUtils;

public class AsynchronousProducer {

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
		 * ASynchronous send
		 * good thorughtput
		 * limit of inflight messages
		 * max.in.flight.requests.per.connection-------------------------how many message send to the server without recieving responses, default value is 5
		 */
		producer.send(record, new ProducerCallback());
		System.out.println("AsynchronousProducer call completed");
		producer.close();
	}
}

class ProducerCallback implements Callback{

	@Override
	public void onCompletion(RecordMetadata metaData, Exception exp) {
		if(!ObjectUtils.isEmpty(exp)) {
			System.out.println("AsynchronousProducer failed with an exception");
		}else {
			 System.out.println("AsynchronousProducer call Success:");
		}
	}
}