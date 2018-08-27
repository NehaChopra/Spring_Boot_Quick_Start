package com.scotch.io.KafkaProducerConsumer.ProducerConsumerExamples.CustomSerializationExample;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
/*
 * Producer properties
 * Effect of setting these properties will be reflected at producer level only.
 * acks 
 * 0 - Producer will not wait for response from broker that whether that message is received or not.
 * Possible loss of messages
 * not retry
 * high throughput
 * NO guarantee that broker has received response.
 * 
 * 1 - Producer will wait for response from leader.Leader will response when it has stored the message in his log. Let's say leader is down then producer can retry.
 * Still cannot guarantee as followers has copy or not. CHanges of loosing messages.
 * 
 * all - When leader and followers all has copied the message. Leader will acknowledge when it had received the acks from all followers. Increase the latency.
 * 
 * retries default 0
 * retries.backoff.ms- time to retry
 * 
 * max.in.flight.requests.per.connection
 */
public class SupplierProducer {

	public static void main(String[] args) throws ParseException, InterruptedException, ExecutionException {
		String topicName = "SupplierTopic";
		
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092, localhost:9093");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "SupplierSerializer");
		
		Producer<String, Supplier> producer = new KafkaProducer<>(properties);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Supplier sp1 = new Supplier(101,"Xyz Pvt Ltd.",df.parse("2016-04-01"));
		Supplier sp2 = new Supplier(102,"Abc Pvt Ltd.",df.parse("2012-01-01"));
		
		ProducerRecord<String, Supplier> record1 = new ProducerRecord<>(topicName, "SUP", sp1);
		ProducerRecord<String, Supplier> record2 = new ProducerRecord<>(topicName, "SUP", sp2);
		
		Future<RecordMetadata> ack1 = producer.send(record1);
		RecordMetadata metaData1 = ack1.get();
		
		System.out.println("Message is sent to Partition no " + metaData1.partition() + " and offset " + metaData1.offset());
		
		
		Future<RecordMetadata> ack2 = producer.send(record2);
		RecordMetadata metaData2 = ack2.get();
		
		System.out.println("Message is sent to Partition no " + metaData2.partition() + " and offset " + metaData2.offset());
		
		
      producer.close();

      System.out.println("SimpleProducer Completed.");
	}
}
