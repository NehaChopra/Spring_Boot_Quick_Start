package com.scotch.io.POJOKafkaProducerConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scotch.io.POJOKafkaProducerConsumer.dto.User;

@SpringBootApplication
public class PojoKafkaProducerConsumerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PojoKafkaProducerConsumerApplication.class, args);
	}
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
   @Override
   public void run(String... strings) throws Exception {
   	for(int index=0; index<10; index++) {
   		User user = new User("firstName"+index, "middleName"+index, "lastName"+index, "displayName"+index, "mName"+index, "mobile"+index, "email"+index);
   		kafkaProducer.send(user);
   	}
   }
}
