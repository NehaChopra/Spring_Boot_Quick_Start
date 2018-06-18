package com.scotch.io.KafkaBatchListener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(id = "batch-listener", topics = "${default.topic.kafkaTopic}")
	public void recieve(@Payload List<String> messages, 
							@Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
							@Header(KafkaHeaders.OFFSET) List<Long> offsets
			) {
		 LOG.info("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		 LOG.info("beginning to consume batch messages");
		 
		 for(int index=0; index<messages.size(); index++) {
			 LOG.info("received message='{}' with partition-offset='{}'",
                messages.get(index), partitions.get(index) + "-" + offsets.get(index));
		 }
		 
		 LOG.info("all batch messages consumed");
	}
}
