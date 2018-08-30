package com.scotch.io.KafkaProducerConsumer.ProducerConsumerExamples.RebalanceActivity;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.assertj.core.util.Arrays;

public class RandomConsumer {

	public static void main(String[] args) {
		String topicName = "RandomProducerTopic";
		String groupName = "RandomGroup";
		
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092, localhost:9093");
		properties.put("group.id", groupName);
		properties.put("keyDeserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("valueDeserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
		RebalanceListner rebalanceListener = new RebalanceListner(consumer);
		
		consumer.subscribe(Arrays.asList(topicName), rebalanceListener);
		
		
		while(true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for(ConsumerRecord<String, String> record : records) {
				System.out.println("Topic:"+ record.topic() +" Partition:" + record.partition() + " Offset:" + record.offset() + " Value:"+ record.value());
				
				rebalanceListener.addOffset(record.topic(), record.partition(), record.offset());
			}
		}
	}
}
