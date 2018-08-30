package com.scotch.io.KafkaProducerConsumer.ProducerConsumerExamples.RebalanceActivity;

import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class RandomProducer {

	public static void main(String[] args) {
		String topicName = "RandomProducerTopic";
		
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092,localhost:9093");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		Producer<String, String> producer = new KafkaProducer<>(properties);
		Random random = new Random();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 01, 01);
		
		while(true) {
			for(int index=0; index<100; index++) {
				String msg = calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DATE) + "," + random.nextInt(1000);
				producer.send(new ProducerRecord<String, String>(topicName,0,"key",msg));
				msg = calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DATE) + "," + random.nextInt(1000);
				producer.send(new ProducerRecord<String, String>(topicName,1,"key",msg));
			}
			calendar.add(Calendar.DATE, 1);
			System.out.println("Data Sent for " + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DATE) );
			 
		}
	}
}
