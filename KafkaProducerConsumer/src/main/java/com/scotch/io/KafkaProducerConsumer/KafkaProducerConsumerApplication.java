package com.scotch.io.KafkaProducerConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerConsumerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerConsumerApplication.class, args);
	}
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
   @Override
   public void run(String... strings) throws Exception {
   	for(int index=0; index<10; index++) {
   		kafkaProducer.send("Spring Kafka Producer and Consumer Demonstration "+ index);
   	}
   }
}
