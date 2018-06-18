package com.scotch.io.KafkaProducerConsumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerConfig.class);
	
   @Value("${spring.kafka.bootstrap-servers}")
   private String bootstrapServers;
   
   @Value("${default.topic.group}")
   private String groupId;
   
   @Bean
   public Map<String, Object> consumerConfigs() {
       Map<String, Object> props = new HashMap<>();
       props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
       props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
       props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
       props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
       props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
       return props;
   }
   
   @Bean
   public ConsumerFactory<String, String> consumerFactory() {
       return new DefaultKafkaConsumerFactory<>(consumerConfigs());
   }
   
   @Bean
   public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
       ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
       factory.setConsumerFactory(consumerFactory());
       return factory;
   }
}

/*
 * https://www.journaldev.com/2389/java-8-features-with-examples#interface-default-static-method
 * https://www.journaldev.com/2800/java-8-date-localdate-localdatetime-instant
 * https://www.journaldev.com/1260/collections-in-java-tutorial#java-collections-overview
 * https://webdesign.tutsplus.com/articles/the-what-why-and-how-of-data-uris-in-web-design--webdesign-8648
 * https://developers.google.com/speed/docs/insights/LeverageBrowserCaching
 * https://www.maxcdn.com/one/visual-glossary/css-sprites/
 * http://www.baeldung.com/java-8-streams
 * https://www.journaldev.com/2774/java-8-stream
 * https://dzone.com/articles/getting-started-rabbitmq-java
 * https://medium.freecodecamp.org/how-to-know-if-apache-kafka-is-right-for-you-1b2e468d52b9
 * https://www.cloudkarafka.com/blog/2016-12-13-part2-2-apache-kafka-for-beginners_example-and-sample-code-java.html
 * https://github.com/CloudKarafka/java-kafka-example/blob/master/src/main/java/KafkaExample.java
 * https://www.cloudkarafka.com/blog/2016-11-30-part1-kafka-for-beginners-what-is-apache-kafka.html#setup-apache-kafka-instance
 * https://github.com/CloudKarafka/java-kafka-example/blob/master/src/main/java/KafkaExample.java
 * http://highscalability.com/learn-how-exploit-multiple-cores-better-performance-and-scalability
 * http://highscalability.com/blog/2018/4/9/give-meaning-to-100-billion-events-a-day-the-analytics-pipel.html
 * https://cloud.google.com/dataflow/?hl=en
 * http://lambda-architecture.net/
 * https://cloud.google.com/bigquery/
 * http://druid.io/druid.html
 * https://www.youtube.com/results?search_query=memcached+java+spring+boot
 * http://www.squid-cache.org/
 * https://varnish-cache.org/
 * http://booksearch.blogspot.com/2010/08/books-of-world-stand-up-and-be-counted.html
 * http://www.haproxy.org/
 * http://katemats.com/distributed-systems-basics-handling-failure-fault-tolerance-and-monitoring/
 * https://stackoverflow.com/questions/17205561/data-modeling-with-kafka-topics-and-partitions
 * https://www.quora.com/What-is-a-good-small-project-for-Kafka-and-Storm
 * https://stackoverflow.com/questions/21892082/looking-for-a-sample-project-with-kafka-storm
 * http://spring.io/projects/spring-kafka
 * https://github.com/confluentinc/examples
 * https://github.com/bbejeck/kafka-streams
 * https://aws.amazon.com/ec2/
 * http://highscalability.com/blog/2011/1/11/google-megastore-3-billion-writes-and-20-billion-read-transa.html
 * http://www.paperplanes.de/2011/12/9/the-magic-of-consistent-hashing.html
 * http://highscalability.com/flickr-architecture
 * https://fenix.tecnico.ulisboa.pt/downloadFile/1407770020544988/Extended%20Abstract.pdf
 * https://www.ibm.com/support/knowledgecenter/SS6PEW_9.4.0/com.ibm.help.fnd.multitenant.doc/c_IntroductionToSharding.html
 * http://www.baeldung.com/elasticsearch-java
 * http://www.mkyong.com/elasticsearch/elasticsearch-hello-world-example/
 * https://solutioncenter.apexsql.com/using-sql-server-database-snapshots-protect-yourself-against-accidental-data-modification/
 * https://www.mssqltips.com/sqlservertip/3603/sql-server-database-snapshots-for-data-comparison/
 * https://www.mssqltips.com/sqlservertip/1010/sql-database-snapshots-for-reporting-auditing-and-data-recovery/
 * https://www.quora.com/What-is-Googles-core-architecture
 * http://infolab.stanford.edu/~backrub/google.html
 * http://highscalability.com/google-architecture
 * https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/#shortestPath
 * https://www.geeksforgeeks.org/
 * https://www.geeksforgeeks.org/top-20-backtracking-algorithm-interview-questions/
 * https://www.geeksforgeeks.org/find-if-there-is-a-path-of-more-than-k-length-from-a-source/
 * https://www.geeksforgeeks.org/backtracking-set-8-solving-cryptarithmetic-puzzles/
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * https://www.youtube.com/watch?v=AshMNCxSp3c&list=PLkz1SCf5iB4enAR00Z46JwY9GGkaS2NON&index=20
 * https://github.com/LearningJournal/ApacheKafkaTutorials
 * https://www.geeksforgeeks.org/find-shortest-safe-route-in-a-path-with-landmines/
 * https://github.com/binhnguyennus/awesome-scalability
 * https://instagram-engineering.com/search-architecture-eeb34a936d3a
 * https://engineering.linkedin.com/kafka/running-kafka-scale
 * https://engineering.linkedin.com/blog/topic/apache-samza
 * https://content.pivotal.io/blog/understanding-when-to-use-rabbitmq-or-apache-kafka
 * https://github.com/abialas/tutorials/tree/master/core-java-9
 * http://hadooptutorial.info/avro-serializing-and-deserializing-example-java-api/
 * https://avro.apache.org/docs/1.8.1/gettingstartedjava.html
 * https://memorynotfound.com/spring-kafka-consume-producer-example/
 * https://www.codenotfound.com/spring-kafka-consumer-producer-example.html
 * https://github.com/bijukunjummen/sample-spring-kafka-producer-consumer/tree/master/sample-spring-kafka-producer/src/main/java/sample/producer/config
 * http://www.javainuse.com/spring/spring-boot-apache-kafka-hello-world
 * http://www.java-allandsundry.com/2016/11/spring-kafka-producerconsumer-sample.html
 * https://dzone.com/articles/developing-async-microservices-architecture-using
 * https://softwaredevelopercentral.blogspot.com/2017/08/spring-boot-kafka-tutorial.html
 * 
 */
