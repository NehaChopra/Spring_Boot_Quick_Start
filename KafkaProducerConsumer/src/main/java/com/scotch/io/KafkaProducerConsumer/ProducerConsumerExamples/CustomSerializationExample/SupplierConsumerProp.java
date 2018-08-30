package com.scotch.io.KafkaProducerConsumer.ProducerConsumerExamples.CustomSerializationExample;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.assertj.core.util.Arrays;
public class SupplierConsumerProp {

	public static void main(String[] args) throws ParseException, InterruptedException, ExecutionException {
		String topicName = "SupplierTopic";
		String groupName = "SuppleirG";
		
		Properties properties = new Properties();
		
		try(InputStream input = new FileInputStream("SupplierConsumer.properties")) {
			properties.load(input);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		KafkaConsumer<String, Supplier> consumer = new KafkaConsumer<>(properties);
		consumer.subscribe(Arrays.asList(topicName));///take a list of topic, regex and wildcard can be used
		/*
		 * telling consumer to read data from topic
		 */
		
		while(true) {
			ConsumerRecords<String, Supplier> records = consumer.poll(100);/// timeout 100 when no value is there
			/*
			 * poll method responsible for:
			 * Connect to group coordinator
			 * join the group
			 * partition assignment 
			 * sends heartbeat to tell it status
			 * fetches the messages
			 * 
			 * On first time poll call, consumer connects with group coordinator, join the group, receive the partition assignment and then fetches the messages
			 * Later poll sends the heartbeat to group coordinator to let know the status of the consumer, consumer should be quick in processing the data
			 * else group coordinator will declare the consumer dead and will initiate the rebalance activity.
			 */
			for(ConsumerRecord<String, Supplier> record: records) {
				 System.out.println("Supplier id= " + String.valueOf(record.value().getSupplierId()) + 
						 " Supplier  Name = " + record.value().getSupplierName() + " Supplier Start Date = " + record.value().getSupplierStartDate().toString());
			}
		}
	}
}
