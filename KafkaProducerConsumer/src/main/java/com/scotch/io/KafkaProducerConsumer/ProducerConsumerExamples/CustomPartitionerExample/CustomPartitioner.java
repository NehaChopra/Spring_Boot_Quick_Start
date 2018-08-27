package com.scotch.io.KafkaProducerConsumer.ProducerConsumerExamples.CustomPartitionerExample;

import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.record.InvalidRecordException;
import org.apache.kafka.common.utils.Utils;
import org.springframework.util.ObjectUtils;

public class CustomPartitioner implements Partitioner{
	private String speedSensorName;

	@Override
	public void configure(Map<String, ?> config) {
		/*
		 * onload
		 */
		speedSensorName = config.get("speed.sensor.name").toString();
	}

	@Override
	public void close() {
	}

	/*
	 * Called for each message when being sent by producer to kalfka, to insert into a spcific partition.
	 */
	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		
		List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
		int numPartitions = partitions.size();
		int p=0;
		int sp = (int)Math.abs(numPartitions*0.3);
		
		if(ObjectUtils.isEmpty(keyBytes) || !(key instanceof String)) {
			throw new InvalidRecordException("All messages must have sensor name as key");
		}
		if(key.equals(speedSensorName)) {
			p = Utils.toPositive(Utils.murmur2(valueBytes)) % sp; //////////mod 3 to fetch values between [0-3]
			/*
			 * Key will be TSS every time, hashing same key will give same value for partition
			 */
		}else {
			 p = Utils.toPositive(Utils.murmur2(keyBytes)) % (numPartitions-sp) + sp ;//////////mod 3 to fetch values between [4-10]

          System.out.println("Key = " + (String)key + " Partition = " + p );
          return p;
		}
		return 0;
	}
}

